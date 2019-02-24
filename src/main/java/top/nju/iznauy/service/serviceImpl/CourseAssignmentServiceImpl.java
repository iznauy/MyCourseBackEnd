package top.nju.iznauy.service.serviceImpl;

import org.springframework.stereotype.Service;
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
@Service
public class CourseAssignmentServiceImpl implements CourseAssignmentService {

    @Override
    public void releaseAssignment(int courseReleaseId, String name, String description, Date deadLine) {

    }

    @Override
    public List<CourseAssignmentVO> getAllAssignments(int releaseId) {
        return null;
    }

    @Override
    public AssignmentDetailVO getAssignmentDetail(int assignmentId) {
        return null;
    }

    @Override
    public CourseAssignmentCommitVO getOwnAssignmentState(String email, int assignmentId) {
        return null;
    }

    @Override
    public TeacherAssignmentCommitStateVO getWholeCommitState(int assignmentId) {
        return null;
    }

    @Override
    public String downloadAssignments(int assignmentId) {
        return null;
    }
}
