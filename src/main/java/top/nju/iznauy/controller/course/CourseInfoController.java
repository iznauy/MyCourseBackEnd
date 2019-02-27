package top.nju.iznauy.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.nju.iznauy.controller.tools.UserToken;
import top.nju.iznauy.service.CourseInfoService;
import top.nju.iznauy.vo.course.CourseInfoVO;

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

    @Autowired
    public void setInfoService(CourseInfoService infoService) {
        this.infoService = infoService;
    }
}
