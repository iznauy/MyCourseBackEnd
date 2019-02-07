package top.nju.iznauy.dao;

import top.nju.iznauy.po.user.StudentPO;
import top.nju.iznauy.po.uservalidation.StudentMailValidationPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface StudentDao {

    StudentPO getStudentByEmail(String email);

    void saveStudent(StudentPO student);

    void saveCode(StudentMailValidationPO studentMailValidation);

    StudentMailValidationPO getStudentMailValidationByEmail(String email);

    List<StudentPO> getStudentsByEmailCollection(Collection<StudentPO> collection);

}
