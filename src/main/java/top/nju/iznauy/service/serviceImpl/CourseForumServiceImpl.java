package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.CourseForumDao;
import top.nju.iznauy.entity.UserType;
import top.nju.iznauy.po.courseforum.CoursePostPO;
import top.nju.iznauy.po.courseforum.CourseReplyPO;
import top.nju.iznauy.service.CourseForumService;
import top.nju.iznauy.vo.forum.PostListVO;
import top.nju.iznauy.vo.forum.PostVO;
import top.nju.iznauy.vo.forum.ReplyListVO;

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
        return null;
    }

    @Override
    public ReplyListVO getReplyList(int postId, int page, int pageSize) {
        return null;
    }

    @Override
    public PostVO getPostDetail(int postId) {
        return null;
    }

    @Autowired
    public void setCourseForumDao(CourseForumDao courseForumDao) {
        this.courseForumDao = courseForumDao;
    }
}
