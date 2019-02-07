package top.nju.iznauy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.PassToken;
import top.nju.iznauy.exception.ServerUnknownException;
import top.nju.iznauy.service.UserService;
import top.nju.iznauy.vo.TokenVO;

import javax.annotation.Resource;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@RestController
public class UserController {

    @Resource(name = "studentService")
    private UserService studentService;

    @Resource(name = "teacherService")
    private UserService teacherService;


    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @PassToken
    public TokenVO login(@RequestParam String email, @RequestParam String password, @RequestParam UserType userType) {
        log.info("用户： " + email + " 登录");
        return getBeanByUserType(userType).login(email, password);
    }


    @GetMapping("/register")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PassToken
    public void register(@RequestParam String email, @RequestParam String password, @RequestParam UserType userType) {
        log.info("邮箱：" + email + " 注册成为 " + userType);
        getBeanByUserType(userType).register(email, password);
    }

    @PassToken
    @GetMapping("/validation")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void validate(@RequestParam String email, @RequestParam UserType userType) {
        log.info("邮箱：" + email + "请求验证码");
        getBeanByUserType(userType).sendValidationCode(email);
    }

    @PassToken
    @PostMapping("/validation")
    @ResponseStatus(HttpStatus.OK)
    public TokenVO validate(@RequestParam String email, @RequestParam String code, @RequestParam UserType userType) {
        return getBeanByUserType(userType).validateUser(email, code);
    }

    private UserService getBeanByUserType(UserType userType) {
        if (userType == UserType.student)
            return studentService;
        else if (userType == UserType.teacher)
            return teacherService;
        throw new ServerUnknownException("未知的用户类型");
    }

}
