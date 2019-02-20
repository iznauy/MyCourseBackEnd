package top.nju.iznauy.controller.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.TeacherToken;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.vo.teacher.TeacherCourseVO;

import java.util.List;

/**
 * Created on 18/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@RequestMapping(value = "teacher/course")
public class TeacherCourseController {

    @PostMapping(value = "/create")
    @TeacherToken
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createCourse(@UserEmail String email, @RequestParam String name,
                             @RequestParam String description) {

    }

    @GetMapping(value = "/list")
    @TeacherToken
    public List<TeacherCourseVO> getOwnCreatedCourses(@UserEmail String email) {
        return null;
    }



}
