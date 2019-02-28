package top.nju.iznauy.service.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.*;
import top.nju.iznauy.entity.Pair;
import top.nju.iznauy.entity.UserType;
import top.nju.iznauy.exception.ServerUnknownException;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.po.courseforum.CoursePostPO;
import top.nju.iznauy.po.courseforum.CourseReplyPO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.po.user.StudentPO;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.service.CourseForumService;
import top.nju.iznauy.vo.forum.PostListVO;
import top.nju.iznauy.vo.forum.PostVO;
import top.nju.iznauy.vo.forum.ReplyListVO;
import top.nju.iznauy.vo.forum.SectionVO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@Service
public class CourseForumServiceImpl implements CourseForumService {

    private CourseForumDao courseForumDao;

    private TeacherDao teacherDao;

    private StudentDao studentDao;

    private CourseDao courseDao;

    private CourseSelectionDao selectionDao;

    private CourseReleaseDao releaseDao;

    private Map<String, UserInfoEntity> getUserInfoEntitiesForTeachers(Collection<String> teacherEmails) {
        Map<String, UserInfoEntity> resultMap = new HashMap<>();
        List<TeacherPO> teachers = teacherDao.getTeachersByEmailCollection(teacherEmails);
        teachers.forEach(e -> resultMap.put(e.getMail(), new UserInfoEntity(UserType.teacher,
                e.getUserName(), e.getAvatar())));
        return resultMap;
    }

    private Map<String, UserInfoEntity> getUserInfoEntitiesForStudents(Collection<String> studentEmails) {
        Map<String, UserInfoEntity> resultMap = new HashMap<>();
        List<StudentPO> students = studentDao.getStudentsByEmailCollection(studentEmails);
        students.forEach(e -> resultMap.put(e.getMail(), new UserInfoEntity(UserType.student,
                e.getUserName(), e.getAvatar())));
        return resultMap;
    }

    private Map<String, UserInfoEntity> getUserInfoEntities(Collection<String> teacherEmails, Collection<String> studentEmails) {
        Map<String, UserInfoEntity> userInfoEntities = getUserInfoEntitiesForStudents(studentEmails);

        Map<String, UserInfoEntity> teacherInfoEntities = getUserInfoEntitiesForTeachers(teacherEmails);
        userInfoEntities.putAll(teacherInfoEntities);

        return userInfoEntities;
    }

    private List<SectionVO> getTeacherAvailableSections(String email) {
        return courseDao.getApprovedCoursesByCreatorEmail(email).stream()
                .map(SectionVO::new).collect(Collectors.toList());
    }

    private List<SectionVO> getStudentAvailableSections(String email) {
        Set<Integer> releaseIds = selectionDao.getSelectionsByUserEmail(email)
                .stream().map(CourseSelectionPO::getCourseReleaseId).collect(Collectors.toSet());
        Set<CoursePO> courses = releaseDao.getReleasesByIds(releaseIds).stream().map(CourseReleasePO::getCourse)
                .collect(Collectors.toSet());
        return courses.stream().map(SectionVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<SectionVO> getAvailableSections(String email, UserType userType) {
        if (userType == UserType.teacher) {
            return getTeacherAvailableSections(email);
        } else if (userType == UserType.student) {
            return getStudentAvailableSections(email);
        } else
            return new ArrayList<>();
    }

    @Override
    public void publishPost(String email, UserType userType, int courseId, String title, String content) {
        CoursePostPO postPO = new CoursePostPO(courseId, title, content, email, userType);
        courseForumDao.savePost(postPO);
    }

    @Override
    public void publishReply(String email, UserType userType, int postId, String content) {
        CourseReplyPO replyPO = new CourseReplyPO(content, email, userType, postId);
        courseForumDao.saveReply(replyPO);
    }

    @Override
    public PostListVO getPostList(int courseId, int page, int pageSize) {
        // 拿到最原始的数据
        Pair<List<CoursePostPO>, Integer> dataPair = courseForumDao.getCoursePosts(courseId, page, pageSize);
        List<CoursePostPO> coursePostPOList = dataPair.getK();
        int totalPage = dataPair.getV();

        Set<String> teacherEmails = coursePostPOList.stream().filter(e -> e.getCreatorIdentity().equals(UserType.teacher))
                .map(CoursePostPO::getCreatorEmail).collect(Collectors.toSet());
        Set<String> studentEmails = coursePostPOList.stream().filter(e -> e.getCreatorIdentity().equals(UserType.student))
                .map(CoursePostPO::getCreatorEmail).collect(Collectors.toSet());
        Map<String, UserInfoEntity> userInfoEntityMap = getUserInfoEntities(teacherEmails, studentEmails);

        List<PostListVO.PostListItemVO> itemVOList = new ArrayList<>();
        for (CoursePostPO post : coursePostPOList) {
            UserInfoEntity entity = userInfoEntityMap.get(post.getCreatorEmail());
            itemVOList.add(new PostListVO.PostListItemVO(post.getId(),
                    post.getCreatorEmail(), entity.creatorType, entity.creatorUsername,
                    entity.creatorAvatar, post.getTitle(),
                    post.getReplyCount(), post.getChangeTime()));
        }
        return new PostListVO(itemVOList, totalPage);
    }

    @Override
    public ReplyListVO getReplyList(int postId, int page, int pageSize) {
        // 原始数据
        Pair<List<CourseReplyPO>, Integer> dataPair = courseForumDao.getPostReplies(postId, page, pageSize);
        List<CourseReplyPO> courseReplyPOList = dataPair.getK();
        int totalPage = dataPair.getV();

        Set<String> teacherEmails = courseReplyPOList.stream().filter(e -> e.getCreatorIdentity().equals(UserType.teacher))
                .map(CourseReplyPO::getCreatorEmail).collect(Collectors.toSet());
        Set<String> studentEmails = courseReplyPOList.stream().filter(e -> e.getCreatorIdentity().equals(UserType.student))
                .map(CourseReplyPO::getCreatorEmail).collect(Collectors.toSet());
        Map<String, UserInfoEntity> userInfoEntityMap = getUserInfoEntities(teacherEmails, studentEmails);

        List<ReplyListVO.ReplyListItemVO> itemVOList = new ArrayList<>();
        for (CourseReplyPO reply : courseReplyPOList) {
            UserInfoEntity entity = userInfoEntityMap.get(reply.getCreatorEmail());
            itemVOList.add(new ReplyListVO.ReplyListItemVO(reply.getId(),
                    reply.getCreatorEmail(), entity.creatorType, entity.creatorUsername,
                    entity.creatorAvatar, reply.getContent(), reply.getCreateTime()));
        }

        return new ReplyListVO(itemVOList, totalPage);
    }

    @Override
    public PostVO getPostDetail(int postId) {
        // 原始PO对象
        CoursePostPO rawPost = courseForumDao.getCoursePostById(postId);

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        if (rawPost.getCreatorIdentity() == UserType.student) {
            StudentPO student = studentDao.getStudentByEmail(rawPost.getCreatorEmail());
            userInfoEntity.creatorAvatar = student.getAvatar();
            userInfoEntity.creatorType = UserType.student;
            userInfoEntity.creatorUsername = student.getUserName();
        } else if (rawPost.getCreatorIdentity() == UserType.teacher) {
            TeacherPO teacher = teacherDao.getTeacherByEmail(rawPost.getCreatorEmail());
            userInfoEntity.creatorUsername = teacher.getUserName();
            userInfoEntity.creatorType = UserType.teacher;
            userInfoEntity.creatorAvatar = teacher.getAvatar();
        } else
            throw new ServerUnknownException("有人在搞我！");
        return new PostVO(postId, rawPost.getCreatorEmail(), userInfoEntity.creatorType,
                userInfoEntity.creatorUsername, userInfoEntity.creatorAvatar,
                rawPost.getTitle(), rawPost.getCreateTime(), rawPost.getContent());
    }

    @Autowired
    public void setCourseForumDao(CourseForumDao courseForumDao) {
        this.courseForumDao = courseForumDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Autowired
    public void setSelectionDao(CourseSelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    @Autowired
    public void setReleaseDao(CourseReleaseDao releaseDao) {
        this.releaseDao = releaseDao;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class UserInfoEntity {

        UserType creatorType;

        String creatorUsername;

        String creatorAvatar;

    }
}
