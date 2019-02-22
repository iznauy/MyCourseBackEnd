package top.nju.iznauy.dao;

import top.nju.iznauy.po.course.CourseReleasePO;

import java.util.List;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseReleaseDao {

    List<CourseReleasePO> getCourseReleaseByCourseId(int courseId);

    CourseReleasePO getCourseReleaseById(int id);

    List<CourseReleasePO> getAvailableReleases();

    List<CourseReleasePO> getUncheckedRelease();

    List<CourseReleasePO> getAllRelease();

    CourseReleasePO getReleaseByCourseIdAndClassOrder(int courseId, int classOrder);

    void saveRelease(CourseReleasePO releasePO);

}