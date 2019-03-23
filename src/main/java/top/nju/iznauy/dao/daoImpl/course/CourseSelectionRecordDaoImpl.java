package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseSelectionRecordDao;
import top.nju.iznauy.po.courseselection.CourseSelectionRecordPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class CourseSelectionRecordDaoImpl implements CourseSelectionRecordDao {

    private CourseSelectionRecordRepository recordRepository;

    @Override
    public void saveRecord(CourseSelectionRecordPO recordPO) {
        recordRepository.save(recordPO);
    }

    @Override
    public void saveRecords(Collection<CourseSelectionRecordPO> recordPOS) {
        recordRepository.saveAll(recordPOS);
    }

    @Override
    public List<CourseSelectionRecordPO> getRecordsByEmail(String email) {
        return recordRepository.findAllByStudentEmail(email);
    }

    @Autowired
    public void setRecordRepository(CourseSelectionRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
}
