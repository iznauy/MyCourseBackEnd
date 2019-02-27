package top.nju.iznauy.vo.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.course.CoursePO;

/**
 * Created on 26/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfoVO {

    private int id;

    private String courseName;

    private String courseDescription;

    private String teacher;

    public CourseInfoVO(CoursePO coursePO, String teacher) {
        this.id = coursePO.getCourseId();
        this.courseName = coursePO.getCourseName();
        this.courseDescription = coursePO.getCourseDescription();
        this.teacher = teacher;
    }

}
