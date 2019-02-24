package top.nju.iznauy.service;

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
public interface CourseAssignmentService {

    void releaseAssignment(int courseReleaseId, String name, String description,
                           Date deadLine);

    List<CourseAssignmentVO> getAllAssignments(int releaseId);

    AssignmentDetailVO getAssignmentDetail(int assignmentId);

    CourseAssignmentCommitVO getOwnAssignmentState(String email, int assignmentId);

    TeacherAssignmentCommitStateVO getWholeCommitState(int assignmentId);

    String downloadAssignments(int assignmentId);

}
