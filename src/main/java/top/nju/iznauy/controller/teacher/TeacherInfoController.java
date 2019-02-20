package top.nju.iznauy.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.TeacherToken;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.service.TeacherInfoService;
import top.nju.iznauy.vo.teacher.TeacherBasicInfoVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherInfoController {

    private TeacherInfoService teacherInfoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    @TeacherToken
    public TeacherBasicInfoVO getTeacherBasicInfo(@UserEmail String email) {
        return teacherInfoService.getBasicInfo(email);
    }

    @TeacherToken
    @PostMapping("/info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyTeacherBasicInfo(@UserEmail String email, String username) {
        teacherInfoService.modifyTeacherBasicInfo(email, username);
    }

    @Autowired
    public void setTeacherInfoService(TeacherInfoService teacherInfoService) {
        this.teacherInfoService = teacherInfoService;
    }
}
