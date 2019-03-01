package top.nju.iznauy.dao;

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
public interface CourseAssignmentDao {

    void saveAssignment(CourseAssignmentPO po);

    List<CourseAssignmentPO> getAssignmentsByCourseReleaseId(int releaseId);

    CourseAssignmentPO getByAssignmentId(int assignmentId);

    CourseAssignmentCommitPO getCommitByAssignmentIdAndStudentEmail(int assignmentId, String studentEmail);

    int countAssignmentCommit(int assignmentId);

    void saveAssignmentCommit(CourseAssignmentCommitPO commitPO);

    void saveAssignmentCommits(Collection<CourseAssignmentCommitPO> commitPOS);

    List<CourseAssignmentCommitPO> getCommitsByAssignmentId(int assignmentId);

}
