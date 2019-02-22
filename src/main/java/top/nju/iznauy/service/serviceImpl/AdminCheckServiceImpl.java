package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nju.iznauy.dao.CourseDao;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.exception.NotExistsException;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.service.AdminCheckService;
import top.nju.iznauy.service.CourseAllocateService;
import top.nju.iznauy.vo.admin.AdminUncheckedCourseReleaseVO;
import top.nju.iznauy.vo.admin.AdminUncheckedCourseVO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 21/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class AdminCheckServiceImpl implements AdminCheckService {

    private CourseDao courseDao;

    private CourseReleaseDao releaseDao;

    private CourseAllocateService courseAllocateService;

    @Override
    public List<AdminUncheckedCourseVO> getUncheckedCourses() {
        return courseDao.getCoursesByCheckState(false).stream()
                .map(AdminUncheckedCourseVO::new).collect(Collectors.toList());
    }

    @Override
    public List<AdminUncheckedCourseReleaseVO> getUncheckedCourseReleases() {
        return releaseDao.getUncheckedRelease().stream()
                .map(AdminUncheckedCourseReleaseVO::new).collect(Collectors.toList());
    }

    @Override
    public void checkCourse(int id, boolean approve) {
        CoursePO coursePO = courseDao.getCourseById(id);
        if (coursePO == null)
            throw new NotExistsException("课程不存在");
        coursePO.setHasChecked(true);
        coursePO.setHasApproved(approve);
        courseDao.saveCourse(coursePO);
    }

    @Override
    public void checkCourseRelease(int id, boolean approve) {
        CourseReleasePO releasePO = releaseDao.getCourseReleaseById(id);
        if (releasePO == null)
            throw new NotExistsException("课程发布不存在");
        releasePO.setHasChecked(true);
        releasePO.setHasApproved(approve);
        releaseDao.saveRelease(releasePO);

        if (releasePO.isHasQuota()) // 自动分配课程
            courseAllocateService.allocateCourseReleaseRandomly(id);
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Autowired
    public void setReleaseDao(CourseReleaseDao releaseDao) {
        this.releaseDao = releaseDao;
    }

    @Autowired
    public void setCourseAllocateService(CourseAllocateService courseAllocateService) {
        this.courseAllocateService = courseAllocateService;
    }
}
