package top.nju.iznauy.dao;

import top.nju.iznauy.po.course.CoursePO;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseDao {

    void saveCourse(CoursePO coursePO);

    CoursePO getCourseById(int id);

    List<CoursePO> getCoursesByCreatorEmail(String email);

    List<CoursePO> getApprovedCoursesByCreatorEmail(String email);

    List<CoursePO> getAllCourses();

    List<CoursePO> getCoursesByCheckState(boolean hasChecked);

    Map<Integer, CoursePO> getCoursesByIds(Collection<Integer> ids);

}
