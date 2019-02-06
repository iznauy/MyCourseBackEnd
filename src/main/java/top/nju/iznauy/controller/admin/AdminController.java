package top.nju.iznauy.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import top.nju.iznauy.controller.tools.PassToken;
import top.nju.iznauy.service.AdminService;
import top.nju.iznauy.vo.TokenVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private AdminService adminService;

    @PassToken
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/login")
    public TokenVO login(String username, String password) {
        return adminService.login(username, password);
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
