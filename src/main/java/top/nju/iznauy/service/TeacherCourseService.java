package top.nju.iznauy.service;

import top.nju.iznauy.vo.teacher.TeacherCourseBasicInfoVO;
import top.nju.iznauy.vo.teacher.TeacherCourseReleaseBasicInfoVO;

import java.util.Date;
import java.util.List;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface TeacherCourseService {

    void createCourse(String email, String courseName, String courseDescription);

    List<TeacherCourseBasicInfoVO> getOwnCreatedCourseList(String email);

    List<TeacherCourseReleaseBasicInfoVO> getAllReleasesByCourseId(String email, int courseId);

    void releaseCourse(String email, int courseId, Date beginDate, Date endDate, int classOrder,
                       boolean hasQuota, int quota);
}
