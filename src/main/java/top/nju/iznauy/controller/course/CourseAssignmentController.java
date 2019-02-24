package top.nju.iznauy.controller.course;

import org.springframework.web.bind.annotation.*;
import top.nju.iznauy.controller.tools.TeacherToken;
import top.nju.iznauy.controller.tools.UserToken;
import top.nju.iznauy.vo.course.AssignmentDetailVO;
import top.nju.iznauy.vo.course.CourseAssignmentVO;

import java.util.List;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RestController
@RequestMapping("/course")
public class CourseAssignmentController {

    @PostMapping("/assignment/create")
    @TeacherToken
    public void releaseAssignment() {

    }

    @GetMapping("/assignments")
    @UserToken
    public List<CourseAssignmentVO> getAssignments(@RequestParam int courseId) {
        return null;
    }

    @GetMapping("/assignment")
    @UserToken
    public AssignmentDetailVO getAssignmentDetail(int assignmentId) {
        return null;
    }

    public void getAssigmentCommitState() {

    }

}
