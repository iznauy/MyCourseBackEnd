package top.nju.iznauy.dao.daoImpl.user;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.user.StudentPO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface StudentRepository extends CrudRepository<StudentPO, String> {

}
