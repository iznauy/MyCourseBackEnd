package top.nju.iznauy.dao;

import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.po.uservalidation.TeacherMailValidationPO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface TeacherDao {

    TeacherPO getTeacherByEmail(String email);

    void saveTeacher(TeacherPO teacherPO);

    void saveCode(TeacherMailValidationPO mailValidationPO);

    TeacherMailValidationPO getTeacherMailValidationPO(String email);

}
