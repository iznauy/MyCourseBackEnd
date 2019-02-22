package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;

import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseSelectionRepository extends CrudRepository<CourseSelectionPO, Integer> {

    List<CourseSelectionPO> findAllByStudentMail(String email);

    CourseSelectionPO findByCourseReleaseIdAndStudentMail(int courseReleaseId, String email);

}
