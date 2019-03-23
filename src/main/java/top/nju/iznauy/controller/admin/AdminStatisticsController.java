package top.nju.iznauy.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import top.nju.iznauy.service.AdminStatisticsService;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Controller
public class AdminStatisticsController {

    private AdminStatisticsService adminStatisticsService;

    @Autowired
    public void setAdminStatisticsService(AdminStatisticsService adminStatisticsService) {
        this.adminStatisticsService = adminStatisticsService;
    }
}
