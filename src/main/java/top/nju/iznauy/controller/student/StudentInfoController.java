package top.nju.iznauy.controller.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.controller.tools.PassToken;
import top.nju.iznauy.controller.tools.StudentToken;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.controller.tools.UserToken;
import top.nju.iznauy.service.StudentInfoService;
import top.nju.iznauy.vo.AvatarVO;
import top.nju.iznauy.vo.StudentBasicInfoVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentInfoController {

    private StudentInfoService studentInfoService;

    /**
     * 账号取消激活（注销，其实只是改变了状态位，让他登不上去而已）
     */
    @StudentToken
    @GetMapping("/logoff")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logOff(@UserEmail String email) {
        studentInfoService.logOff(email);
    }

    @StudentToken
    @GetMapping("/info")
    public StudentBasicInfoVO getStudentBasicInfo(@UserEmail String email) {
        return studentInfoService.getBasicInfo(email);
    }

    @StudentToken
    @PostMapping("/info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyStudentBasicInfo(@UserEmail String email, String username, String number) {
        studentInfoService.modifyStudentBasicInfo(email, username, number);
    }

    /**
     * 获取别人的头像不需要token
     */
    @PassToken
    @GetMapping("/avatar")
    public AvatarVO getAvatar(@RequestParam String email) {
        return studentInfoService.getAvatar(email);
    }

    /**
     * 获取自身头像，可以不用传email，但是需要传token，这个方法其实可有可无
     */
    @StudentToken
    @GetMapping("/ownAvatar")
    public AvatarVO getOwnAvatar(@UserEmail String email) {
        return studentInfoService.getAvatar(email);
    }

    /**
     * 上传头像
     */
    @StudentToken
    @PostMapping("/avatar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void uploadAvatar(@UserEmail String email, MultipartFile avatar) {
        studentInfoService.uploadAvatar(email, avatar);
    }

    @Autowired
    public void setStudentInfoService(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }
}
