package top.nju.iznauy.dao;

import top.nju.iznauy.po.courseforum.CoursePostPO;
import top.nju.iznauy.po.courseforum.CourseReplyPO;

import java.util.List;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseFourmDao {

    // TODO: 这边其实需要分页功能，晚上回来了再写吧
    List<CoursePostPO> getCoursePosts(int courseId);

    List<CourseReplyPO> getPostReplys(int replyTo);

    void savePost(CoursePostPO postPO);

    void saveReply(CourseReplyPO replyPO);

}
