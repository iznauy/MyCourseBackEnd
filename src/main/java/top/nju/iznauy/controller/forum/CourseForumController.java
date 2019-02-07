package top.nju.iznauy.controller.forum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.controller.tools.UserToken;
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
@RestController
@RequestMapping("/forum")
public class CourseForumController {

    private CourseForumService courseForumService;

    @UserToken
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void publishPost(@UserEmail String email, @RequestParam UserType userType,
                            @RequestParam int courseId, @RequestParam String title,
                            @RequestParam String content) {
        courseForumService.publishPost(email, userType, courseId, title, content);
    }

    @UserToken
    @PostMapping("/reply")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void publishReply(@UserEmail String email, @RequestParam UserType userType,
                             @RequestParam int postId, @RequestParam String content) {
        courseForumService.publishReply(email, userType, postId, content);
    }


    @UserToken
    @GetMapping("/post")
    public PostListVO getPostList(@RequestParam int courseId, @RequestParam int page,
                                  @RequestParam int pageSize) {
        return courseForumService.getPostList(courseId, page, pageSize);
    }

    @UserToken
    @GetMapping("/reply")
    public ReplyListVO getReplyList(@RequestParam int postId, @RequestParam int page,
                                    @RequestParam int pageSize) {
        return courseForumService.getReplyList(postId, page, pageSize);
    }

    @UserToken
    @GetMapping("/postdetail")
    public PostVO getPostDetail(@RequestParam int postId) {
        return courseForumService.getPostDetail(postId);
    }

    @Autowired
    public void setCourseForumService(CourseForumService courseForumService) {
        this.courseForumService = courseForumService;
    }
}
