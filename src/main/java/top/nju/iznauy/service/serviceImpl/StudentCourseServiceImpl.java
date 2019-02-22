package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.CourseDao;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.dao.CourseSelectionRecordDao;
import top.nju.iznauy.exception.NotExistsException;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.service.StudentCourseService;
import top.nju.iznauy.vo.student.StudentCourseReleaseBasicInfoVO;

import java.util.List;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
@Slf4j
public class StudentCourseServiceImpl implements StudentCourseService {

    private CourseSelectionDao selectionDao;

    private CourseSelectionRecordDao selectionRecordDao;

    @Override
    public List<StudentCourseReleaseBasicInfoVO> getAvailableCourses(String email) {
        return null;
    }

    @Override
    public List<StudentCourseReleaseBasicInfoVO> getOwnCourses(String email) {
        return null;
    }

    @Override
    public void selectCourse(String email, int id) {

    }

    @Override
    public void quitCourse(String email, int id) {

    }


    public void setSelectionDao(CourseSelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    public void setSelectionRecordDao(CourseSelectionRecordDao selectionRecordDao) {
        this.selectionRecordDao = selectionRecordDao;
    }

}
