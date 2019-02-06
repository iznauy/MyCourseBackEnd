package top.nju.iznauy.controller.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.controller.tools.UserToken;
import top.nju.iznauy.vo.TeacherBasicInfoVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherInfoController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    @UserToken
    public TeacherBasicInfoVO getTeacherBasicInfo(@UserEmail String email) {
        return null;
    }

    @UserToken
    @PostMapping("/info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyTeacherBasicInfo(@UserEmail String email, String username) {

    }

}
