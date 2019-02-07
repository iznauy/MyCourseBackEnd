package top.nju.iznauy.dao;

import top.nju.iznauy.entity.Pair;
import top.nju.iznauy.po.courseforum.CoursePostPO;
import top.nju.iznauy.po.courseforum.CourseReplyPO;

import java.util.List;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseForumDao {

    // 帖子查询，同时返回总页数
    Pair<List<CoursePostPO>, Integer> getCoursePosts(int courseId, int page, int pageSize);

    // 子回复查询，同时返回子回复
    Pair<List<CourseReplyPO>, Integer> getPostReplies(int replyTo, int page, int pageSize);

    void savePost(CoursePostPO postPO);

    void saveReply(CourseReplyPO replyPO);

}
