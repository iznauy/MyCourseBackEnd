package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.CourseDao;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.dao.StudentDao;
import top.nju.iznauy.dao.TeacherDao;
import top.nju.iznauy.service.AdminStatisticsService;
import top.nju.iznauy.vo.admin.AccountCountVO;
import top.nju.iznauy.vo.admin.CourseCountVO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class AdminStatisticsServiceImpl implements AdminStatisticsService {

    private StudentDao studentDao;

    private TeacherDao teacherDao;

    private CourseDao courseDao;

    private CourseReleaseDao releaseDao;

    @Override
    public AccountCountVO accountRecord() {
        int studentCount = studentDao.countActiveStudents();
        int teacherCount = teacherDao.countHasValidatedTeacher();
        return new AccountCountVO(studentCount, teacherCount);
    }

    @Override
    public CourseCountVO courseAndReleaseRecord() {
        int courseCount = courseDao.countAvailableCourse();
        int releaseCount = releaseDao.countAvailableRelease();
        return new CourseCountVO(courseCount, releaseCount);
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Autowired
    public void setReleaseDao(CourseReleaseDao releaseDao) {
        this.releaseDao = releaseDao;
    }
}
