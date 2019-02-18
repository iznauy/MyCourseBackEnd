package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.controller.tools.JwtTokenUtils;
import top.nju.iznauy.dao.StudentDao;
import top.nju.iznauy.entity.UserType;
import top.nju.iznauy.exception.*;
import top.nju.iznauy.po.user.StudentPO;
import top.nju.iznauy.po.uservalidation.StudentMailValidationPO;
import top.nju.iznauy.service.UserService;
import top.nju.iznauy.service.tool.MailService;
import top.nju.iznauy.tools.CodeRandomGenerator;
import top.nju.iznauy.vo.AvatarVO;
import top.nju.iznauy.vo.TokenVO;


/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@Service("studentService")
public class StudentServiceImpl implements UserService {

    private StudentDao studentDao;

    private MailService mailService;

    @Override
    public TokenVO login(String email, String password) {
        StudentPO studentPO = studentDao.getStudentByEmail(email);
        if (studentPO == null)
            throw new IncorrectAccountException("账号不存在");
        if (!studentPO.getPassword().equals(password))
            throw new IncorrectAccountException("密码错误");
        if (!studentPO.isHasValidated()) // 没有激活
            throw new NotActivationException();
        if (studentPO.isHasCancelled()) // 取消了激活
            throw new NotActivationException();

        String token = JwtTokenUtils.createToken(email, UserType.student);
        return new TokenVO(token);
    }

    @Override
    public void register(String email, String password) {
        StudentPO rawStudent = studentDao.getStudentByEmail(email);
        if (rawStudent != null)
            throw new EmailDuplicateException("已注册");
        StudentPO studentPO = new StudentPO(email, password);
        studentDao.saveStudent(studentPO);
    }

    @Override
    public void sendValidationCode(String email) {
        StudentPO rawStudent = studentDao.getStudentByEmail(email);
        if (rawStudent == null)
            throw new IncorrectAccountException("账号不存在");
        String code = CodeRandomGenerator.randomGenerateCode();
        studentDao.saveCode(new StudentMailValidationPO(email, code));
        mailService.sentMail(email, code);
    }

    @Override
    public TokenVO validateUser(String email, String code) {
        StudentMailValidationPO mailValidationPO = studentDao.getStudentMailValidationByEmail(email);
        if (mailValidationPO == null)
            throw new ServerUnknownException("尚未发送验证邮件");
        if (code.equals(mailValidationPO.getCode())) {
            // 验证是对的了
            StudentPO studentPO = studentDao.getStudentByEmail(email);
            // 设置用户验证状态、激活状态并存储
            studentPO.setHasValidated(true);
            studentPO.setHasCancelled(false);
            studentDao.saveStudent(studentPO);
        } else
            throw new IncorrectCodeException("验证码有误");
        String token = JwtTokenUtils.createToken(email, UserType.student);
        return new TokenVO(token);
    }

    @Override
    public AvatarVO getAvatar(String email) {
        StudentPO studentPO = studentDao.getStudentByEmail(email);
        return new AvatarVO(studentPO.getAvatar());
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }
}
