package top.nju.iznauy.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.controller.tools.StudentToken;
import top.nju.iznauy.controller.tools.TeacherToken;
import top.nju.iznauy.controller.tools.UserEmail;
import top.nju.iznauy.controller.tools.UserToken;
import top.nju.iznauy.service.CourseAssignmentService;
import top.nju.iznauy.vo.course.AssignmentDetailVO;
import top.nju.iznauy.vo.course.CourseAssignmentCommitVO;
import top.nju.iznauy.vo.course.CourseAssignmentVO;
import top.nju.iznauy.vo.course.TeacherAssignmentCommitStateVO;

import java.util.Date;
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

    private CourseAssignmentService assignmentService;

    @PostMapping("/assignment/create")
    @TeacherToken
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void releaseAssignment(int courseReleaseId, String name,
                                  String description, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date deadLine) {
        assignmentService.releaseAssignment(courseReleaseId, name, description, deadLine);
    }

    @GetMapping("/assignments")
    @UserToken
    public List<CourseAssignmentVO> getAssignments(@RequestParam int courseReleaseId) {
        return assignmentService.getAllAssignments(courseReleaseId);
    }

    @GetMapping("/assignment")
    @UserToken
    public AssignmentDetailVO getAssignmentDetail(@RequestParam int assignmentId) {
        return assignmentService.getAssignmentDetail(assignmentId);
    }

    @GetMapping("/assignment/own")
    @StudentToken
    public CourseAssignmentCommitVO getOwnAssignmentState(@UserEmail String email, @RequestParam int assignmentId) {
        return assignmentService.getOwnAssignmentState(email, assignmentId);
    }

    @TeacherToken
    @GetMapping("/assignment/state")
    public TeacherAssignmentCommitStateVO getWholeCommitState(@RequestParam int assignmentId) {
        return assignmentService.getWholeCommitState(assignmentId);
    }

    @StudentToken
    @PostMapping("/assignment/commit")
    public void commitAssignment(@RequestBody MultipartFile assignment, @UserEmail String email, int assignmentId) {
        assignmentService.upLoadAssignment(assignment, assignmentId, email);
    }

    @TeacherToken
    @GetMapping("/assignment/download")
    public String downloadAssignments(@RequestParam int assignmentId) {
        return assignmentService.downloadAssignments(assignmentId);
    }

    @Autowired
    public void setAssignmentService(CourseAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }
}
