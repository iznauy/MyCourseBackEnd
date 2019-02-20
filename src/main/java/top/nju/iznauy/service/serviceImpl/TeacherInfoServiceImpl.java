package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.TeacherDao;
import top.nju.iznauy.exception.IncorrectAccountException;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.service.TeacherInfoService;
import top.nju.iznauy.vo.teacher.TeacherBasicInfoVO;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    private TeacherDao teacherDao;

    private void checkTeacher(TeacherPO teacherPO) {
        if (teacherPO == null)
            throw new IncorrectAccountException("账号不存在");
    }

    @Override
    public TeacherBasicInfoVO getBasicInfo(String email) {
        TeacherPO teacherPO = teacherDao.getTeacherByEmail(email);
        checkTeacher(teacherPO);

        return new TeacherBasicInfoVO(email, teacherPO.getUserName());
    }

    @Override
    public void modifyTeacherBasicInfo(String email, String username) {
        TeacherPO teacherPO = teacherDao.getTeacherByEmail(email);
        checkTeacher(teacherPO);

        teacherPO.setUserName(username);
        teacherDao.saveTeacher(teacherPO);
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
}
