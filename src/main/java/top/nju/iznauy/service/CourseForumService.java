package top.nju.iznauy.service;

import top.nju.iznauy.entity.UserType;
import top.nju.iznauy.vo.forum.PostListVO;
import top.nju.iznauy.vo.forum.PostVO;
import top.nju.iznauy.vo.forum.ReplyListVO;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseForumService {

    void publishPost(String email, UserType userType, int courseId, String title, String content);

    void publishReply(String email, UserType userType, int postId, String content);

    PostListVO getPostList(int courseId, int page, int pageSize);

    ReplyListVO getReplyList(int postId, int page, int pageSize);

    PostVO getPostDetail(int postId);

}
