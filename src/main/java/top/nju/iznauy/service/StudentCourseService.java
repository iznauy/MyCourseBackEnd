package top.nju.iznauy.service;

import top.nju.iznauy.vo.student.StudentCourseReleaseBasicInfoVO;
import top.nju.iznauy.vo.student.StudentScoreVO;

import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface StudentCourseService {

    List<StudentCourseReleaseBasicInfoVO> getAvailableCourses(String email);

    List<StudentCourseReleaseBasicInfoVO> getOwnCourses(String email);

    StudentScoreVO getReleaseScore(String email, int releaseId);

    void selectCourse(String email, int id);

    void quitCourse(String email, int id);

}
