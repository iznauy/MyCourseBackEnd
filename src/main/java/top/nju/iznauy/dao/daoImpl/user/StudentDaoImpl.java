package top.nju.iznauy.dao.daoImpl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    public List<StudentPO> getStudents(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return studentRepository.findAll((e0, e1, e2) -> {
            e1.where(e2.equal(e0.<Boolean>get("hasValidated"), true)); // 必须是已经激活的用户才会被分配课程
            return null;
        }, pageRequest).getContent();
    }

    @Override
    public List<StudentPO> getStudentsByEmailCollection(Collection<String> collection) {
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
