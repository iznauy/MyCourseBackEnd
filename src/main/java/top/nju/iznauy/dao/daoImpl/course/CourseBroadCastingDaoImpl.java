package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseBroadCastingDao;
import top.nju.iznauy.po.course.BroadCastingPO;

/**
 * Created on 28/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class CourseBroadCastingDaoImpl implements CourseBroadCastingDao {

    private BroadCastingRepository broadCastingRepository;

    @Override
    public void addBroadCasting(BroadCastingPO po) {
        broadCastingRepository.save(po);
    }

    @Override
    public BroadCastingPO getLatestBroadCasting(int releaseId) {
        return broadCastingRepository.findTopByReleaseIdOrderByCreateTimeDesc(releaseId);
    }

    @Autowired
    public void setBroadCastingRepository(BroadCastingRepository broadCastingRepository) {
        this.broadCastingRepository = broadCastingRepository;
    }
}
