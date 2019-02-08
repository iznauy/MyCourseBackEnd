package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.controller.tools.JwtTokenUtils;
import top.nju.iznauy.dao.TeacherDao;
import top.nju.iznauy.entity.UserType;
import top.nju.iznauy.exception.*;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.po.uservalidation.TeacherMailValidationPO;
import top.nju.iznauy.service.UserService;
import top.nju.iznauy.service.tool.MailService;
import top.nju.iznauy.tools.CodeRandomGenerator;
import top.nju.iznauy.vo.TokenVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service("teacherService")
public class TeacherServiceImpl implements UserService {

    private TeacherDao teacherDao;

    private MailService mailService;

    @Override
    public TokenVO login(String email, String password) {
        TeacherPO teacherPO = teacherDao.getTeacherByEmail(email);
        if (teacherPO == null)
            throw new IncorrectAccountException("账号不存在");
        if (!teacherPO.getPassword().equals(password))
            throw new IncorrectAccountException("密码错误");
        if (!teacherPO.isHasValidated()) // 没有激活过
            throw new NotActivationException();

        String token = JwtTokenUtils.createToken(email, UserType.teacher);
        return new TokenVO(token);
    }

    @Override
    public void register(String email, String password) {
        TeacherPO rawTeacher = teacherDao.getTeacherByEmail(email);
        if (rawTeacher != null)
            throw new EmailDuplicateException("已注册");
        TeacherPO teacherPO = new TeacherPO(email, password);
        teacherDao.saveTeacher(teacherPO);
    }

    @Override
    public void sendValidationCode(String email) {
        TeacherPO rawTeacher = teacherDao.getTeacherByEmail(email);
        if (rawTeacher != null)
            throw new IncorrectAccountException("账号不存在");
        String code = CodeRandomGenerator.randomGenerateCode();
        teacherDao.saveCode(new TeacherMailValidationPO(email, code));
        mailService.sentMail(email, code);
    }

    @Override
    public TokenVO validateUser(String email, String code) {
        TeacherMailValidationPO mailValidationPO = teacherDao.getTeacherMailValidationPO(email);
        if (mailValidationPO == null)
            throw new ServerUnknownException("尚未发送验证邮件");
        if (code.equals(mailValidationPO.getCode())) {
            TeacherPO teacherPO = teacherDao.getTeacherByEmail(email);
            teacherPO.setHasValidated(true);
            teacherDao.saveTeacher(teacherPO);
        } else
            throw new IncorrectCodeException("验证码有误");
        String token = JwtTokenUtils.createToken(email, UserType.teacher);
        return new TokenVO(token);
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }
}
