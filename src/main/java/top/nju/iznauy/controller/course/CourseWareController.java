package top.nju.iznauy.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.controller.tools.TeacherToken;
import top.nju.iznauy.controller.tools.UserToken;
import top.nju.iznauy.service.CourseWareService;
import top.nju.iznauy.vo.course.CourseWareVO;

import java.util.List;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@RequestMapping(value = "/course")
public class CourseWareController {

    private CourseWareService courseWareService;

    @GetMapping("/ware")
    @UserToken
    @ResponseStatus(HttpStatus.OK)
    public List<CourseWareVO> getCourseWares(@RequestParam int courseId) {
        return courseWareService.getCourseWares(courseId);
    }


    @PostMapping("/ware")
    @TeacherToken
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCourseWare(int courseId, String name, MultipartFile ware) {
        courseWareService.addCourseWare(courseId, name, ware);
    }

    @Autowired
    public void setCourseWareService(CourseWareService courseWareService) {
        this.courseWareService = courseWareService;
    }
}
