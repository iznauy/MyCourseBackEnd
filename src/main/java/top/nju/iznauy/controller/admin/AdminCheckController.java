package top.nju.iznauy.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.AdminToken;
import top.nju.iznauy.service.AdminCheckService;
import top.nju.iznauy.vo.admin.AdminUncheckedCourseReleaseVO;
import top.nju.iznauy.vo.admin.AdminUncheckedCourseVO;

import java.util.List;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminCheckController {

    private AdminCheckService checkService;

    @AdminToken
    @GetMapping("/course")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminUncheckedCourseVO> getUncheckedCourses() {
        return checkService.getUncheckedCourses();
    }

    @AdminToken
    @GetMapping("/courseRelease")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminUncheckedCourseReleaseVO> getUncheckedCourseReleases() {
        return checkService.getUncheckedCourseReleases();
    }

    @AdminToken
    @PostMapping("/course")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void checkCourse(int id, boolean approve) {
        log.info("Check Course: " + id + ", " + approve);
        checkService.checkCourse(id, approve);
    }

    @AdminToken
    @PostMapping("/courseRelease")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void checkCourseRelease(int id, boolean approve) {
        log.info("Check CourseRelease: " + id + ", " + approve);
        checkService.checkCourseRelease(id, approve);
    }

    @Autowired
    public void setCheckService(AdminCheckService checkService) {
        this.checkService = checkService;
    }
}
