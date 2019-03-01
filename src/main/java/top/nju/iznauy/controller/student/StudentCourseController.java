package top.nju.iznauy.controller.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.StudentToken;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.service.StudentCourseService;
import top.nju.iznauy.vo.student.StudentCourseReleaseBasicInfoVO;
import top.nju.iznauy.vo.student.StudentScoreVO;

import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentCourseController {

    private StudentCourseService courseService;

    @StudentToken
    @GetMapping("/allCourse")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentCourseReleaseBasicInfoVO> getAvailableCourses(@UserEmail String email) {
        return courseService.getAvailableCourses(email);
    }

    @StudentToken
    @GetMapping("/release/score")
    @ResponseStatus(HttpStatus.OK)
    public StudentScoreVO getReleaseScore(@UserEmail String email, int releaseId) {
        return courseService.getReleaseScore(email, releaseId);
    }

    @StudentToken
    @GetMapping("/myCourse")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentCourseReleaseBasicInfoVO> getOwnCourses(@UserEmail String email) {
        return courseService.getOwnCourses(email);
    }

    @StudentToken
    @PostMapping("/course/select")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void selectCourse(@UserEmail String email, int id) {
        courseService.selectCourse(email, id);
    }

    @StudentToken
    @DeleteMapping("/course/select")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void quitCourse(@UserEmail String email, int id) {
        log.info("用户：" + email + " 取消选择课程" + id);
        courseService.quitCourse(email, id);
        log.info("取消选课完毕");
    }

    @Autowired
    public void setCourseService(StudentCourseService courseService) {
        this.courseService = courseService;
    }
}
