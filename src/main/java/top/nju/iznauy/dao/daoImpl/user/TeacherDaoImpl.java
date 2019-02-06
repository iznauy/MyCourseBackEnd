package top.nju.iznauy.dao.daoImpl.user;

import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.TeacherDao;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.po.uservalidation.TeacherMailValidationPO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public TeacherPO getTeacherByEmail(String email) {
        return null;
    }

    @Override
    public void saveTeacher(TeacherPO teacherPO) {

    }

    @Override
    public void saveCode(TeacherMailValidationPO mailValidationPO) {

    }

    @Override
    public TeacherMailValidationPO getTeacherMailValidationPO(String email) {
        return null;
    }
}
