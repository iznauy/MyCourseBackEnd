package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.course.CourseReleasePO;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseReleaseRepository extends CrudRepository<CourseReleasePO, Integer>,
        JpaSpecificationExecutor<CourseReleasePO> {

    List<CourseReleasePO> findAllByIdIn(Collection<Integer> ids);

    List<CourseReleasePO> findAllByHasChecked(boolean hasChecked);

    List<CourseReleasePO> findAllByBeginDateBeforeAndEndDateAfterAndHasApproved(Date date1, Date date2, boolean hasApproved);
}
