package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.dao.StudentDao;
import top.nju.iznauy.exception.IncorrectAccountException;
import top.nju.iznauy.po.user.StudentPO;
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
@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    private StudentDao studentDao;

    private void checkStudent(StudentPO studentPO) {
        if (studentPO == null)
            throw new IncorrectAccountException("账号不存在");
    }

    @Override
    public void logOff(String email) {
        StudentPO studentPO = studentDao.getStudentByEmail(email);
        // 防御式编程
        checkStudent(studentPO);

        studentPO.setHasCancelled(true);
        studentDao.saveStudent(studentPO);
    }

    @Override
    public StudentBasicInfoVO getBasicInfo(String email) {
        StudentPO studentPO = studentDao.getStudentByEmail(email);
        checkStudent(studentPO);
        return new StudentBasicInfoVO(email, studentPO.getUserName(), studentPO.getNumber(), studentPO.getAvatar());
    }

    @Override
    public void modifyStudentBasicInfo(String email, String username, String number) {
        StudentPO studentPO = studentDao.getStudentByEmail(email);
        checkStudent(studentPO);

        studentPO.setUserName(username);
        studentPO.setNumber(number);

        studentDao.saveStudent(studentPO);
    }

    @Override
    public AvatarVO getAvatar(String email) {
        StudentPO studentPO = studentDao.getStudentByEmail(email);
        checkStudent(studentPO);
        return new AvatarVO(studentPO.getAvatar());
    }

    @Override
    public void uploadAvatar(String email, MultipartFile avatar) {
        // todo: 头像上传
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
