package top.nju.iznauy.dao.daoImpl;

import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.StudentDao;
import top.nju.iznauy.po.user.StudentPO;
import top.nju.iznauy.po.uservalidation.StudentMailValidationPO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public StudentPO getStudentByEmail(String email) {
        return null;
    }

    @Override
    public void saveStudent(StudentPO student) {

    }

    @Override
    public void saveCode(StudentMailValidationPO studentMailValidation) {

    }

    @Override
    public StudentMailValidationPO getStudentMailValidationByEmail(String email) {
        return null;
    }
}
