package top.nju.iznauy.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.nju.iznauy.controller.tools.StudentToken;
import top.nju.iznauy.controller.tools.TeacherToken;
import top.nju.iznauy.controller.tools.UserToken;
import top.nju.iznauy.service.CourseInfoService;
import top.nju.iznauy.vo.course.ClassStudentVO;
import top.nju.iznauy.vo.course.ClassmateVO;
import top.nju.iznauy.vo.course.CourseInfoVO;

import java.util.List;

/**
 * Created on 26/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
public class CourseInfoController {

    private CourseInfoService infoService;

    @UserToken
    @GetMapping("/course/info")
    public CourseInfoVO getCourseInfo(int id) {
        return infoService.getCourseInfo(id);
    }

    @StudentToken
    @GetMapping("/course/member")
    public List<ClassStudentVO> getStudentsByReleases(int releaseId) {
        return infoService.getStudentsByReleases(releaseId);
    }

    @TeacherToken
    @GetMapping("/release/member")
    public List<ClassmateVO> getClassmates(int releaseId) {
        return infoService.getClassmatesByReleases(releaseId);
    }

    @Autowired
    public void setInfoService(CourseInfoService infoService) {
        this.infoService = infoService;
    }
}
