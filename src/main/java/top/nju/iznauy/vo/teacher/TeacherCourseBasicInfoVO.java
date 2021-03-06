package top.nju.iznauy.vo.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.course.CoursePO;

import java.util.Date;

/**
 * Created on 18/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCourseBasicInfoVO implements Comparable<TeacherCourseBasicInfoVO> {

    private int id;

    private String name;

    private String description;

    private boolean approve;

    private boolean check;

    private Date createDate;

    public TeacherCourseBasicInfoVO(CoursePO po) {
        id = po.getCourseId();
        name = po.getCourseName();
        description = po.getCourseDescription();
        approve = po.isHasApproved();
        check = po.isHasChecked();
        createDate = po.getCreateDate();
    }

    @Override
    public int compareTo(TeacherCourseBasicInfoVO o) {
        if (o.createDate.before(createDate))
            return -1;
        else if (createDate.before(o.createDate))
            return 1;
        else
            return 0;
    }
}
