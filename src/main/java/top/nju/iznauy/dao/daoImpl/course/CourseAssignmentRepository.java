package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.courseassignment.CourseAssignmentPO;

import java.util.List;

/**
 * Created on 25/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseAssignmentRepository extends CrudRepository<CourseAssignmentPO, Integer> {

    List<CourseAssignmentPO> findAllByCourseReleaseId(int releaseId);

}
