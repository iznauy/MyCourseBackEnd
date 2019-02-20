package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.course.CoursePO;

import java.util.List;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseRepository extends CrudRepository<CoursePO, Integer> {

    List<CoursePO> findAllByCourseCreatorMail(String email);

    List<CoursePO> findAllByHasChecked(boolean hasChecked);

}
