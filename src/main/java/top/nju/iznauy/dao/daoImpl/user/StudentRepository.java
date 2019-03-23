package top.nju.iznauy.dao.daoImpl.user;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.user.StudentPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface StudentRepository extends CrudRepository<StudentPO, String>, JpaSpecificationExecutor<StudentPO> {

    List<StudentPO> findAllByMailIn(Collection<String> studentPOS);

    int countByHasValidated(boolean hasValidated);

}
