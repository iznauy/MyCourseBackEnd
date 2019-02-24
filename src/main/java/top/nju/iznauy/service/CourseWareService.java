package top.nju.iznauy.service;

import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.vo.course.CourseWareVO;

import java.util.List;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseWareService {

    List<CourseWareVO> getCourseWares(int courseId);

    void addCourseWare(int courseId, String name, MultipartFile ware);

}
