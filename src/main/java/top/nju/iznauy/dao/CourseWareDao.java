package top.nju.iznauy.dao;

import top.nju.iznauy.po.courseware.CourseWarePO;

import java.util.List;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseWareDao {

    void saveCourseWare(CourseWarePO courseWarePO);

    List<CourseWarePO> getCourseWaresByCourseId(int courseId);

}
