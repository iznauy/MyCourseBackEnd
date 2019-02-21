package top.nju.iznauy.service;

import top.nju.iznauy.vo.admin.AdminUncheckedCourseReleaseVO;
import top.nju.iznauy.vo.admin.AdminUncheckedCourseVO;

import java.util.List;

/**
 * Created on 21/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface AdminCheckService {

    List<AdminUncheckedCourseVO> getUncheckedCourses();

    List<AdminUncheckedCourseReleaseVO> getUncheckedCourseReleases();

    void checkCourse(int id, boolean approve);

    void checkCourseRelease(int id, boolean approve);

}
