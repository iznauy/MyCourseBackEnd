package top.nju.iznauy.dao;

import top.nju.iznauy.po.courseselection.CourseSelectionRecordPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseSelectionRecordDao {

    void saveRecord(CourseSelectionRecordPO recordPO);

    void saveRecords(Collection<CourseSelectionRecordPO> recordPOS);

    List<CourseSelectionRecordPO> getRecordsByEmail(String email);

}
