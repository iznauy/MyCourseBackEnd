package top.nju.iznauy.vo.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.courseassignment.CourseAssignmentPO;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseAssignmentVO {

    private int id;

    private String name;

    public CourseAssignmentVO(CourseAssignmentPO po) {
        id = po.getId();
        name = po.getName();
    }

}
