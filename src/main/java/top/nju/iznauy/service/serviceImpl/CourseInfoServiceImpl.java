package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.CourseDao;
import top.nju.iznauy.dao.TeacherDao;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.service.CourseInfoService;
import top.nju.iznauy.vo.course.CourseInfoVO;

/**
 * Created on 26/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class CourseInfoServiceImpl implements CourseInfoService {

    private TeacherDao teacherDao;

    private CourseDao courseDao;

    @Override
    public CourseInfoVO getCourseInfo(int id) {
        CoursePO coursePO = courseDao.getCourseById(id);
        TeacherPO teacherPO = teacherDao.getTeacherByEmail(coursePO.getCourseCreatorMail());
        return new CourseInfoVO(coursePO, teacherPO.getUserName());
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
