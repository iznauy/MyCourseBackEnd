package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nju.iznauy.dao.*;
import top.nju.iznauy.po.course.BroadCastingPO;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.po.user.StudentPO;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.service.CourseInfoService;
import top.nju.iznauy.service.tool.MailService;
import top.nju.iznauy.vo.course.BroadCastingVO;
import top.nju.iznauy.vo.course.ClassStudentVO;
import top.nju.iznauy.vo.course.ClassmateVO;
import top.nju.iznauy.vo.course.CourseInfoVO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 26/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
@Slf4j
public class CourseInfoServiceImpl implements CourseInfoService {

    private TeacherDao teacherDao;

    private CourseDao courseDao;

    private CourseSelectionDao selectionDao;

    private StudentDao studentDao;

    private CourseBroadCastingDao broadCastingDao;

    private MailBroadCastingService broadCastingService;

    @Override
    public CourseInfoVO getCourseInfo(int id) {
        CoursePO coursePO = courseDao.getCourseById(id);
        TeacherPO teacherPO = teacherDao.getTeacherByEmail(coursePO.getCourseCreatorMail());
        return new CourseInfoVO(coursePO, teacherPO.getUserName());
    }

    private List<StudentPO> getReleaseStudents(int releaseId) {
        List<String> students = selectionDao.getSelectionsByReleaseId(releaseId).stream()
                .map(CourseSelectionPO::getStudentMail).collect(Collectors.toList());
        return studentDao.getStudentsByEmailCollection(students);
    }

    @Override
    public List<ClassStudentVO> getStudentsByReleases(int releaseId) {
        return getReleaseStudents(releaseId).stream().map(ClassStudentVO::new).collect(Collectors.toList());
    }

    @Override
    public List<ClassmateVO> getClassmatesByReleases(int releaseId) {
        return getReleaseStudents(releaseId).stream().map(ClassmateVO::new).collect(Collectors.toList());
    }

    @Override
    public BroadCastingVO getBroadCastingByReleaseId(int releaseId) {
        BroadCastingPO po = broadCastingDao.getLatestBroadCasting(releaseId);
        if (po != null)
            return new BroadCastingVO(po);
        else
            return new BroadCastingVO();
    }

    @Override
    @Transactional
    public void addBroadCasting(int releaseId, String content) {
        BroadCastingPO po = new BroadCastingPO(releaseId, content);
        broadCastingDao.addBroadCasting(po);

        broadCastingService.sendBroadCasting(releaseId, content);
        log.info("发布公告方法结束！");
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
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
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setBroadCastingDao(CourseBroadCastingDao broadCastingDao) {
        this.broadCastingDao = broadCastingDao;
    }

    @Autowired
    public void setBroadCastingService(MailBroadCastingService broadCastingService) {
        this.broadCastingService = broadCastingService;
    }
}
