package top.nju.iznauy.vo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.course.CourseReleasePO;

import java.util.Date;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseReleaseBasicInfoVO {

    private int id; // release id

    private int courseId;

    private Date begin;

    private Date end;

    private int classOrder;

    private String name;

    public StudentCourseReleaseBasicInfoVO(CourseReleasePO releasePO) {
        this.id = releasePO.getId();
        this.courseId = releasePO.getCourse().getCourseId();
        this.begin = releasePO.getBeginDate();
        this.end = releasePO.getEndDate();
        this.classOrder = releasePO.getClassOrder();
        this.name = releasePO.getCourse().getCourseName();
    }

}
