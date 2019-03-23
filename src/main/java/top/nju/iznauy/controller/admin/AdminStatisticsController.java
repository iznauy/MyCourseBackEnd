package top.nju.iznauy.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.nju.iznauy.controller.tools.AdminToken;
import top.nju.iznauy.service.AdminStatisticsService;
import top.nju.iznauy.vo.admin.AccountCountVO;
import top.nju.iznauy.vo.admin.CourseCountVO;

import java.util.Date;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminStatisticsController {

    private AdminStatisticsService adminStatisticsService;

    // 老师、学生的个数
    @AdminToken
    @GetMapping("/users")
    public AccountCountVO accountRecord() {
        return adminStatisticsService.accountRecord();
    }

    @AdminToken
    @GetMapping("/courses")
    public CourseCountVO courseAndReleaseRecord() {
        return adminStatisticsService.courseAndReleaseRecord();
    }


    @Autowired
    public void setAdminStatisticsService(AdminStatisticsService adminStatisticsService) {
        this.adminStatisticsService = adminStatisticsService;
    }
}
