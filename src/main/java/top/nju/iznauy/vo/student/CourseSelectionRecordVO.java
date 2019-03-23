package top.nju.iznauy.vo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.courseselection.CourseSelectionRecordPO;

import java.util.Date;

/**
 * Created on 23/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSelectionRecordVO {

    private int id;

    private String courseName;

    private String teacherName;

    private boolean isSelect;

    private Date operateTime;

    public CourseSelectionRecordVO(CourseSelectionRecordPO po, String teacherName) {
        this.id = po.getId();
        this.courseName = po.getCourseRelease().getCourse().getCourseName();
        this.teacherName = teacherName;
        this.isSelect = po.isSelect();
        this.operateTime = po.getOperateTime();
    }

}
