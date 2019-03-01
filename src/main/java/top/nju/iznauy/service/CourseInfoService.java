package top.nju.iznauy.service;

import top.nju.iznauy.vo.course.BroadCastingVO;
import top.nju.iznauy.vo.course.ClassStudentVO;
import top.nju.iznauy.vo.course.ClassmateVO;
import top.nju.iznauy.vo.course.CourseInfoVO;

import java.util.List;

/**
 * Created on 26/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseInfoService {

    CourseInfoVO getCourseInfo(int id);

    List<ClassStudentVO> getStudentsByReleases(int releaseId);

    List<ClassmateVO> getClassmatesByReleases(int releaseId);

    BroadCastingVO getBroadCastingByReleaseId(int releaseId);

    void addBroadCasting(int releaseId, String content);

}
