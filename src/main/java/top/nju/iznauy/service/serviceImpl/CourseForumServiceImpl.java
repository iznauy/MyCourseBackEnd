package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.nju.iznauy.entity.UserType;
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

    @Override
    public void publishPost(String email, UserType userType, int courseId, String title, String content) {

    }

    @Override
    public void publishReply(String email, UserType userType, int postId, String content) {

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
}
