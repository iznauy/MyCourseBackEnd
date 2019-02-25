package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.dao.CourseAssignmentDao;
import top.nju.iznauy.po.courseassignment.CourseAssignmentCommitPO;
import top.nju.iznauy.po.courseassignment.CourseAssignmentPO;
import top.nju.iznauy.service.CourseAssignmentService;
import top.nju.iznauy.service.tool.DirectoryOperations;
import top.nju.iznauy.service.tool.FileOperations;
import top.nju.iznauy.service.tool.ZipOperations;
import top.nju.iznauy.vo.course.AssignmentDetailVO;
import top.nju.iznauy.vo.course.CourseAssignmentCommitVO;
import top.nju.iznauy.vo.course.CourseAssignmentVO;
import top.nju.iznauy.vo.course.TeacherAssignmentCommitStateVO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class CourseAssignmentServiceImpl implements CourseAssignmentService {

    private CourseAssignmentDao assignmentDao;

    @Override
    public void releaseAssignment(int courseReleaseId, String name, String description, Date deadLine) {
        CourseAssignmentPO assignment = new CourseAssignmentPO(courseReleaseId, name, description, deadLine);
        assignmentDao.saveAssignment(assignment);
        DirectoryOperations.createAssignmentFolder(assignment.getId());
    }

    @Override
    public List<CourseAssignmentVO> getAllAssignments(int releaseId) {
        return assignmentDao.getAssignmentsByCourseReleaseId(releaseId)
                .stream().map(CourseAssignmentVO::new).collect(Collectors.toList());
    }

    @Override
    public AssignmentDetailVO getAssignmentDetail(int assignmentId) {
        return new AssignmentDetailVO(assignmentDao.getByAssignmentId(assignmentId));
    }

    @Override
    public CourseAssignmentCommitVO getOwnAssignmentState(String email, int assignmentId) {
        CourseAssignmentCommitPO commitPO = assignmentDao.getCommitByAssignmentIdAndStudentEmail(assignmentId, email);
        if (commitPO == null)
            return null;
        else
            return new CourseAssignmentCommitVO(commitPO);
    }

    @Override
    public TeacherAssignmentCommitStateVO getWholeCommitState(int assignmentId) {
        return new TeacherAssignmentCommitStateVO(assignmentDao.countAssignmentCommit(assignmentId));
    }

    @Override
    public String downloadAssignments(int assignmentId) {
        return ZipOperations.assignmentFolderToZip(assignmentId);
    }

    @Override
    public void upLoadAssignment(MultipartFile assignment, int assignmentId, String email) {
        CourseAssignmentCommitPO commit = assignmentDao.getCommitByAssignmentIdAndStudentEmail(assignmentId, email);
        if (commit == null) {
            commit = new CourseAssignmentCommitPO(assignmentId, null, email, new Date());
        } else {
            commit.setUpLoadTime(new Date());
        }
        String path = FileOperations.saveCourseAssignmentCommit(assignment, assignmentId, email);
        commit.setPath(path);
        assignmentDao.saveAssignmentCommit(commit);
    }

    @Autowired
    public void setAssignmentDao(CourseAssignmentDao assignmentDao) {
        this.assignmentDao = assignmentDao;
    }
}
