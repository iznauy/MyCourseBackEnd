package top.nju.iznauy.vo.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.course.CourseReleasePO;

import java.util.Date;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCourseReleaseBasicInfoVO {

    private int id;

    private int courseId;

    private Date begin;

    private Date end;

    private boolean approve;

    private boolean check;

    private int classOrder;

    private boolean hasQuota;

    private int quota;

    private int count;

    public TeacherCourseReleaseBasicInfoVO(CourseReleasePO po) {
        id = po.getId();
        courseId = po.getCourse().getCourseId();
        begin = po.getBeginDate();
        end = po.getEndDate();
        approve = po.isHasApproved();
        check = po.isHasChecked();
        classOrder = po.getClassOrder();
        hasQuota = po.isHasQuota();
        quota = po.getQuota();
        count = po.getCount();
    }

}
