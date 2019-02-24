package top.nju.iznauy.dao.daoImpl.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseWareDao;
import top.nju.iznauy.po.courseware.CourseWarePO;

import java.util.List;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class CourseWareDaoImpl implements CourseWareDao {

    private CourseWareRepository wareRepository;

    @Override
    public void saveCourseWare(CourseWarePO courseWarePO) {
        wareRepository.save(courseWarePO);
    }

    @Override
    public List<CourseWarePO> getCourseWaresByCourseId(int courseId) {
        return wareRepository.findAllByCourseId(courseId);
    }

    @Autowired
    public void setWareRepository(CourseWareRepository wareRepository) {
        this.wareRepository = wareRepository;
    }
}
