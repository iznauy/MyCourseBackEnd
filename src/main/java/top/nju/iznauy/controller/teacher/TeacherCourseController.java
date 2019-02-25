package top.nju.iznauy.controller.teacher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.TeacherToken;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.service.TeacherCourseService;
import top.nju.iznauy.vo.teacher.TeacherCourseBasicInfoVO;
import top.nju.iznauy.vo.teacher.TeacherCourseReleaseBasicInfoVO;

import java.util.Date;
import java.util.List;

/**
 * Created on 18/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@Slf4j
@RequestMapping(value = "teacher/course")
public class TeacherCourseController {

    private TeacherCourseService teacherCourseService;

    @PostMapping(value = "/create")
    @TeacherToken
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createCourse(@UserEmail String email, @RequestParam String name,
                             @RequestParam String description) {
        teacherCourseService.createCourse(email, name, description);
    }

    @GetMapping(value = "/list")
    @TeacherToken
    public List<TeacherCourseBasicInfoVO> getOwnCreatedCourses(@UserEmail String email) {
        return teacherCourseService.getOwnCreatedCourseList(email);
    }

    @GetMapping(value = "/release")
    @TeacherToken
    public List<TeacherCourseReleaseBasicInfoVO> getCourseReleases(@UserEmail String email, @RequestParam int courseId) {
        return teacherCourseService.getAllReleasesByCourseId(email, courseId);
    }

    @GetMapping(value = "/allRelease")
    @TeacherToken
    public List<TeacherCourseReleaseBasicInfoVO> getAllCourseReleases(@UserEmail String email) {
        return teacherCourseService.getAllReleasesByTeacherEmail(email);
    }

    @PostMapping(value = "/release")
    @TeacherToken
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void releaseCourse(@UserEmail String email, int id,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                      Date beginDate,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                      Date endDate, int classOrder,
                              boolean hasQuota, int quota) {
        log.info("创建发布: " + beginDate + " to " + endDate);
        teacherCourseService.releaseCourse(email, id, beginDate, endDate, classOrder, hasQuota, quota);
    }

    @Autowired
    public void setTeacherCourseService(TeacherCourseService teacherCourseService) {
        this.teacherCourseService = teacherCourseService;
    }
}
