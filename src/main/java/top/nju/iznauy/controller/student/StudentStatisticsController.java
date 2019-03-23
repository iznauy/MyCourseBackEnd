package top.nju.iznauy.controller.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.nju.iznauy.controller.tools.StudentToken;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.service.StudentStatisticsService;
import top.nju.iznauy.vo.student.CourseSelectionRecordVO;
import top.nju.iznauy.vo.student.StudentStatisticsScoreVO;

import java.util.List;

/**
 * Created on 23/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@RestController
@RequestMapping("/student/statistics")
public class StudentStatisticsController {

    private StudentStatisticsService studentStatisticsService;

    @StudentToken
    @GetMapping("/selectRecord")
    public List<CourseSelectionRecordVO> getCourseSelectRecords(@UserEmail String email) {
        return studentStatisticsService.getCourseSelectRecords(email);
    }

    @StudentToken
    @GetMapping("/scores")
    public List<StudentStatisticsScoreVO> getCourseScores(@UserEmail String email) {
        return studentStatisticsService.getCourseScores(email);
    }

    @Autowired
    public void setStudentStatisticsService(StudentStatisticsService studentStatisticsService) {
        this.studentStatisticsService = studentStatisticsService;
    }
}
