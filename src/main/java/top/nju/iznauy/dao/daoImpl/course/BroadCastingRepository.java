package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.course.BroadCastingPO;

/**
 * Created on 28/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface BroadCastingRepository extends CrudRepository<BroadCastingPO, Integer> {

    BroadCastingPO findTopByReleaseIdOrderByCreateTimeDesc(int releaseId);

}
