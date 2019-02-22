package top.nju.iznauy.dao.daoImpl.user;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import top.nju.iznauy.po.user.StudentPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface StudentRepository extends PagingAndSortingRepository<StudentPO, String>, JpaSpecificationExecutor<StudentPO> {

    List<StudentPO> findAllByMailIn(Collection<String> studentPOS);

}
