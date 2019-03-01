package top.nju.iznauy.dao.daoImpl.log;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.log.RegisterLogPO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
public interface RegisterLogRepository extends CrudRepository<RegisterLogPO, Long> {
}
