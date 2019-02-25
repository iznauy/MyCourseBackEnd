package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.courseassignment.CourseAssignmentCommitPO;

/**
 * Created on 25/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseAssignmentCommitRepository extends CrudRepository<CourseAssignmentCommitPO, Integer> {

    CourseAssignmentCommitPO findByAssignmentIdAndUpLoader(int assignmentId, String upLoader);

    int countByAssignmentId(int assignmentId);

}
