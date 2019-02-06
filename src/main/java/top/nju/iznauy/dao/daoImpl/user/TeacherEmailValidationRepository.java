package top.nju.iznauy.dao.daoImpl.user;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.po.uservalidation.TeacherMailValidationPO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface TeacherEmailValidationRepository extends CrudRepository<TeacherMailValidationPO, String> {
}
