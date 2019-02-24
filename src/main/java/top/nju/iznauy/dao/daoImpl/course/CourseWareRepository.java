package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.courseware.CourseWarePO;

import java.util.List;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseWareRepository extends CrudRepository<CourseWarePO, Integer> {

    List<CourseWarePO> findAllByCourseId(int courseId);

}
