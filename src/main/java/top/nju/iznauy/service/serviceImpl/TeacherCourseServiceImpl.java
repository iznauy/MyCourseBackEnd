package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.CourseDao;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.exception.DuplicationException;
import top.nju.iznauy.exception.NotExistsException;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.service.TeacherCourseService;
import top.nju.iznauy.service.tool.DirectoryOperations;
import top.nju.iznauy.vo.teacher.TeacherCourseBasicInfoVO;
import top.nju.iznauy.vo.teacher.TeacherCourseReleaseBasicInfoVO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

    private CourseDao courseDao;

    private CourseReleaseDao courseReleaseDao;

    @Override
    public void createCourse(String email, String courseName, String courseDescription) {
        CoursePO coursePO = new CoursePO(courseName, courseDescription, email);
        courseDao.saveCourse(coursePO);
        DirectoryOperations.createCourseFolder(coursePO.getCourseId());
    }

    @Override
    public List<TeacherCourseBasicInfoVO> getOwnCreatedCourseList(String email) {
        List<CoursePO> rawCourseList = courseDao.getCoursesByCreatorEmail(email);
        return rawCourseList.stream().
                map(TeacherCourseBasicInfoVO::new).collect(Collectors.toList());
    }

    @Override
    public List<TeacherCourseReleaseBasicInfoVO> getAllReleasesByCourseId(String email, int courseId) {
        return courseReleaseDao.getCourseReleaseByCourseId(courseId).stream().filter(
                e -> e.getCourse().getCourseCreatorMail().equals(email)) // 检测是否是该用户创建的
                .map(TeacherCourseReleaseBasicInfoVO::new).collect(Collectors.toList());
    }

    @Override
    public List<TeacherCourseReleaseBasicInfoVO> getAllReleasesByTeacherEmail(String email) {
        return courseReleaseDao.getAllReleases(email)
                .stream().map(TeacherCourseReleaseBasicInfoVO::new).collect(Collectors.toList());
    }

    @Override
    public void releaseCourse(String email, int courseId, Date beginDate, Date endDate,
                              int classOrder, boolean hasQuota, int quota) {
        CourseReleasePO sameCourseRelease = courseReleaseDao.getReleaseByCourseIdAndClassOrder(courseId, classOrder);
        if (sameCourseRelease != null)
            throw new DuplicationException("已存在该班次");
        CoursePO coursePO = courseDao.getCourseById(courseId);
        if (coursePO == null)
            throw new NotExistsException("课程不存在");
        CourseReleasePO releasePO = new CourseReleasePO(coursePO, beginDate, endDate, classOrder, hasQuota, quota);
        courseReleaseDao.saveRelease(releasePO);
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Autowired
    public void setCourseReleaseDao(CourseReleaseDao courseReleaseDao) {
        this.courseReleaseDao = courseReleaseDao;
    }
}
