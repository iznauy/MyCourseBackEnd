package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.course.CourseReleasePO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class CourseReleaseDaoImpl implements CourseReleaseDao {

    private CourseReleaseRepository courseReleaseRepository;

    @Override
    public List<CourseReleasePO> getCourseReleaseByCourseId(int courseId) {
        return courseReleaseRepository.findAll((e0, e1, e2) -> {
            e1.where(
                    e2.equal(e0.<CoursePO>get("course").get("courseId"), courseId));
            return null;
        });
    }

    @Override
    public CourseReleasePO getCourseReleaseById(int id) {
        return courseReleaseRepository.findById(id).orElse(null);
    }

    @Override
    public List<CourseReleasePO> getAvailableReleases() {
        Date now = new Date();
        return courseReleaseRepository.findAllByBeginDateBeforeAndEndDateAfterAndHasApproved(now, now, true);
    }

    @Override
    public List<CourseReleasePO> getUncheckedRelease() {
        return courseReleaseRepository.findAllByHasChecked(false);
    }

    @Override
    public List<CourseReleasePO> getAllRelease() {
        List<CourseReleasePO> results = new ArrayList<>();
        courseReleaseRepository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CourseReleasePO getReleaseByCourseIdAndClassOrder(int courseId, int classOrder) {
        return courseReleaseRepository.findOne((e0, e1, e2) -> {
            e1.where(
                    e2.and(
                            e2.equal(e0.<CoursePO>get("course").get("courseId"), courseId),
                            e2.equal(e0.get("classOrder"), classOrder))
            );
            return null;
        }).orElse(null);
    }

    @Override
    public List<CourseReleasePO> getReleasesByIds(Collection<Integer> ids) {
        return courseReleaseRepository.findAllByIdIn(ids);
    }

    @Override
    public void saveRelease(CourseReleasePO releasePO) {
        courseReleaseRepository.save(releasePO);
    }

    @Autowired
    public void setCourseReleaseRepository(CourseReleaseRepository courseReleaseRepository) {
        this.courseReleaseRepository = courseReleaseRepository;
    }
}
