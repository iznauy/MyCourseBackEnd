package top.nju.iznauy.vo.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.courseassignment.CourseAssignmentCommitPO;

import java.util.Date;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseAssignmentCommitVO {

    private int id;

    private String path;

    private boolean scored;

    private Integer score;

    private Date upLoadTime;

    public CourseAssignmentCommitVO(CourseAssignmentCommitPO po) {
        id = po.getId();
        path = po.getPath();
        scored = po.isScored();
        score = po.getScore();
        upLoadTime = po.getUpLoadTime();
    }

}
