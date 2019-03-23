package top.nju.iznauy.dao.daoImpl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.TeacherDao;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.po.uservalidation.TeacherMailValidationPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class TeacherDaoImpl implements TeacherDao {

    private TeacherRepository teacherRepository;

    private TeacherEmailValidationRepository emailValidationRepository;

    @Override
    public TeacherPO getTeacherByEmail(String email) {
        return teacherRepository.findById(email).orElse(null);
    }

    @Override
    public void saveTeacher(TeacherPO teacherPO) {
        teacherRepository.save(teacherPO);
    }

    @Override
    public void saveCode(TeacherMailValidationPO mailValidationPO) {
        emailValidationRepository.save(mailValidationPO);
    }

    @Override
    public TeacherMailValidationPO getTeacherMailValidationPO(String email) {
        return emailValidationRepository.findById(email).orElse(null);
    }

    @Override
    public List<TeacherPO> getTeachersByEmailCollection(Collection<String> collection) {
        return teacherRepository.findAllByMailIn(collection);
    }

    @Override
    public int countHasValidatedTeacher() {
        return teacherRepository.countByHasValidated(true);
    }

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    public void setEmailValidationRepository(TeacherEmailValidationRepository emailValidationRepository) {
        this.emailValidationRepository = emailValidationRepository;
    }

}
