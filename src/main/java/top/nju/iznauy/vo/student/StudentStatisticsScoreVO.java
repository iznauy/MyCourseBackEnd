package top.nju.iznauy.vo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;

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
public class StudentStatisticsScoreVO {

    private String courseName;

    private Date scoreTime;

    private int score;

    public StudentStatisticsScoreVO(CourseSelectionPO po, String courseName) {
        this.courseName = courseName;
        this.score = po.getScore();
        this.scoreTime = po.getScoreDate();
    }

}
