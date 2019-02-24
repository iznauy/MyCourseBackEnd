package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.dao.CourseWareDao;
import top.nju.iznauy.po.courseware.CourseWarePO;
import top.nju.iznauy.service.CourseWareService;
import top.nju.iznauy.service.tool.FileOperations;
import top.nju.iznauy.vo.course.CourseWareVO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
@Slf4j
public class CourseWareServiceImpl implements CourseWareService {

    private CourseWareDao courseWareDao;

    @Override
    public List<CourseWareVO> getCourseWares(int courseId) {
        return courseWareDao.getCourseWaresByCourseId(courseId)
                .stream().map(CourseWareVO::new).collect(Collectors.toList());
    }

    @Override
    public void addCourseWare(int courseId, String name, MultipartFile ware) {
        String path = FileOperations.saveCourseWare(ware, courseId, name);
        CourseWarePO warePO = new CourseWarePO(courseId, name, path);
        courseWareDao.saveCourseWare(warePO);
    }

    @Autowired
    public void setCourseWareDao(CourseWareDao courseWareDao) {
        this.courseWareDao = courseWareDao;
    }
}
