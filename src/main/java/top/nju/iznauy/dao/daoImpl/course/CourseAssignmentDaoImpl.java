package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseAssignmentDao;
import top.nju.iznauy.po.courseassignment.CourseAssignmentCommitPO;
import top.nju.iznauy.po.courseassignment.CourseAssignmentPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 25/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class CourseAssignmentDaoImpl implements CourseAssignmentDao {

    private CourseAssignmentRepository assignmentRepository;

    private CourseAssignmentCommitRepository assignmentCommitRepository;

    @Override
    public void saveAssignment(CourseAssignmentPO po) {
        assignmentRepository.save(po);
    }

    @Override
    public List<CourseAssignmentPO> getAssignmentsByCourseReleaseId(int releaseId) {
        return assignmentRepository.findAllByCourseReleaseId(releaseId);
    }

    @Override
    public CourseAssignmentPO getByAssignmentId(int assignmentId) {
        return assignmentRepository.findById(assignmentId).orElse(null);
    }

    @Override
    public CourseAssignmentCommitPO getCommitByAssignmentIdAndStudentEmail(int assignmentId, String studentEmail) {
        return assignmentCommitRepository.findByAssignmentIdAndUpLoader(assignmentId, studentEmail);
    }

    @Override
    public int countAssignmentCommit(int assignmentId) {
        return assignmentCommitRepository.countByAssignmentId(assignmentId);
    }

    @Override
    public void saveAssignmentCommit(CourseAssignmentCommitPO commitPO) {
        assignmentCommitRepository.save(commitPO);
    }

    @Override
    public void saveAssignmentCommits(Collection<CourseAssignmentCommitPO> commitPOS) {
        assignmentCommitRepository.saveAll(commitPOS);
    }

    @Override
    public List<CourseAssignmentCommitPO> getCommitsByAssignmentId(int assignmentId) {
        return assignmentCommitRepository.findAllByAssignmentId(assignmentId);
    }

    @Autowired
    public void setAssignmentRepository(CourseAssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Autowired
    public void setAssignmentCommitRepository(CourseAssignmentCommitRepository assignmentCommitRepository) {
        this.assignmentCommitRepository = assignmentCommitRepository;
    }
}
