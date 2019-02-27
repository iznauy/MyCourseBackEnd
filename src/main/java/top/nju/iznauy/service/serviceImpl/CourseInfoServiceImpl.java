package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.CourseDao;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.dao.StudentDao;
import top.nju.iznauy.dao.TeacherDao;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.po.user.StudentPO;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.service.CourseInfoService;
import top.nju.iznauy.vo.course.ClassStudentVO;
import top.nju.iznauy.vo.course.ClassmateVO;
import top.nju.iznauy.vo.course.CourseInfoVO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    private CourseSelectionDao selectionDao;

    private StudentDao studentDao;

    @Override
    public CourseInfoVO getCourseInfo(int id) {
        CoursePO coursePO = courseDao.getCourseById(id);
        TeacherPO teacherPO = teacherDao.getTeacherByEmail(coursePO.getCourseCreatorMail());
        return new CourseInfoVO(coursePO, teacherPO.getUserName());
    }

    private List<StudentPO> getReleaseStudents(int releaseId) {
        List<String> students = selectionDao.getSelectionsByReleaseId(releaseId).stream()
                .map(CourseSelectionPO::getStudentMail).collect(Collectors.toList());
        return studentDao.getStudentsByEmailCollection(students);
    }

    @Override
    public List<ClassStudentVO> getStudentsByReleases(int releaseId) {
        return getReleaseStudents(releaseId).stream().map(ClassStudentVO::new).collect(Collectors.toList());
    }

    @Override
    public List<ClassmateVO> getClassmatesByReleases(int releaseId) {
        return getReleaseStudents(releaseId).stream().map(ClassmateVO::new).collect(Collectors.toList());
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
    public void setSelectionDao(CourseSelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
