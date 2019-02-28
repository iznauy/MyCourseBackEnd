package top.nju.iznauy.dao;

import top.nju.iznauy.po.course.BroadCastingPO;

/**
 * Created on 28/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseBroadCastingDao {

    void addBroadCasting(BroadCastingPO po);

    BroadCastingPO getLatestBroadCasting(int releaseId);

}
