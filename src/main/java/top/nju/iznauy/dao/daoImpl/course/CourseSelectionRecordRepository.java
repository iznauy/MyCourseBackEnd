package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.courseselection.CourseSelectionRecordPO;

import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseSelectionRecordRepository extends CrudRepository<CourseSelectionRecordPO, Integer> {

    List<CourseSelectionRecordPO> findAllByStudentEmail(String email);

}
