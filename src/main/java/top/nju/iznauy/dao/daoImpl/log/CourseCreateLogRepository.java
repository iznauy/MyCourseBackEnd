package top.nju.iznauy.dao.daoImpl.log;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.log.CourseCreateLogPO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseCreateLogRepository extends CrudRepository<CourseCreateLogPO, Long> {
}
