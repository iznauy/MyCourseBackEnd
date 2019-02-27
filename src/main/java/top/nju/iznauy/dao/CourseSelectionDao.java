package top.nju.iznauy.dao;

import top.nju.iznauy.po.courseselection.CourseSelectionPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseSelectionDao {

    CourseSelectionPO getCourseSelectionByCourseReleaseIdAndStudentEmail(int courseReleaseId, String email);

    void saveSelection(CourseSelectionPO selectionPO);

    void saveSelections(Collection<CourseSelectionPO> selectionPOS);

    void deleteSelection(CourseSelectionPO selectionPO);

    List<CourseSelectionPO> getSelectionsByUserEmail(String email);

    List<CourseSelectionPO> getSelectionsByReleaseId(int releaseId);

}
