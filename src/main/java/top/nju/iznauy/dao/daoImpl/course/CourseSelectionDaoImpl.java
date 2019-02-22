package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;

import java.util.Collection;
import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class CourseSelectionDaoImpl implements CourseSelectionDao {

    private CourseSelectionRepository selectionRepository;

    @Override
    public CourseSelectionPO getCourseSelectionByCourseReleaseIdAndStudentEmail(int courseReleaseId, String email) {
        return selectionRepository.findByCourseReleaseIdAndStudentMail(courseReleaseId, email);
    }

    @Override
    public void saveSelection(CourseSelectionPO selectionPO) {
        selectionRepository.save(selectionPO);
    }

    @Override
    public void saveSelections(Collection<CourseSelectionPO> selectionPOS) {
        selectionRepository.saveAll(selectionPOS);
    }

    @Override
    public void deleteSelection(CourseSelectionPO selectionPO) {
        selectionRepository.delete(selectionPO);
    }

    @Override
    public List<CourseSelectionPO> getSelectionsByUserEmail(String email) {
        return selectionRepository.findAllByStudentMail(email);
    }

    @Autowired
    public void setSelectionRepository(CourseSelectionRepository selectionRepository) {
        this.selectionRepository = selectionRepository;
    }
}
