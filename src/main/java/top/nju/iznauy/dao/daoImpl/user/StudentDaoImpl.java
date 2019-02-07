package top.nju.iznauy.dao.daoImpl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.StudentDao;
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
@Repository
public class StudentDaoImpl implements StudentDao {

    private StudentRepository studentRepository;

    private StudentEmailValidationRepository emailValidationRepository;


    @Override
    public StudentPO getStudentByEmail(String email) {
        return studentRepository.findById(email).orElse(null);
    }

    @Override
    public void saveStudent(StudentPO student) {
        studentRepository.save(student);
    }

    @Override
    public void saveCode(StudentMailValidationPO studentMailValidation) {
        emailValidationRepository.save(studentMailValidation);
    }

    @Override
    public StudentMailValidationPO getStudentMailValidationByEmail(String email) {
        return emailValidationRepository.findById(email).orElse(null);
    }

    @Override
    public List<StudentPO> getStudentsByEmailCollection(Collection<StudentPO> collection) {
        return studentRepository.findAllByMailIn(collection);
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setEmailValidationRepository(StudentEmailValidationRepository emailValidationRepository) {
        this.emailValidationRepository = emailValidationRepository;
    }


}
