package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseDao;
import top.nju.iznauy.po.course.CoursePO;

import java.util.*;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class CourseDaoImpl implements CourseDao {

    private CourseRepository courseRepository;

    @Override
    public void saveCourse(CoursePO coursePO) {
        courseRepository.save(coursePO);
    }

    @Override
    public CoursePO getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }


    @Override
    public List<CoursePO> getApprovedCoursesByCreatorEmail(String email) {
        return courseRepository.findAllByHasApprovedAndCourseCreatorMail(true, email);
    }

    @Override
    public List<CoursePO> getCoursesByCreatorEmail(String email) {
        return courseRepository.findAllByCourseCreatorMail(email);
    }

    @Override
    public List<CoursePO> getAllCourses() {
        Iterable<CoursePO> coursePOS = courseRepository.findAll();
        List<CoursePO> result = new ArrayList<>();
        coursePOS.forEach(result::add);
        return result;
    }

    @Override
    public List<CoursePO> getCoursesByCheckState(boolean hasChecked) {
        return courseRepository.findAllByHasChecked(hasChecked);
    }

    @Override
    public Map<Integer, CoursePO> getCoursesByIds(Collection<Integer> ids) {
        Map<Integer, CoursePO> resultMap = new HashMap<>();
        courseRepository.findAllById(ids).forEach(e -> resultMap.put(e.getCourseId(), e));
        return resultMap;
    }

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
