package top.nju.iznauy.service;

import top.nju.iznauy.vo.student.CourseSelectionRecordVO;
import top.nju.iznauy.vo.student.StudentStatisticsScoreVO;

import java.util.List;

/**
 * Created on 23/03/2019.
 * Description:
 *
 * @author iznauy
 */
public interface StudentStatisticsService {

    List<CourseSelectionRecordVO> getCourseSelectRecords(String email);

    List<StudentStatisticsScoreVO> getCourseScores(String email);
}
