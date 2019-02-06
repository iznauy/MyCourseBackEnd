package top.nju.iznauy.po.courseassignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Table
@Entity
@Data
public class CourseAssignmentCommitPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int assignmentId;

    @Column(nullable = false)
    private String path;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean scored;

    @Column
    private Integer score;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date upLoadTime;

    public CourseAssignmentCommitPO(int assignmentId, String path, boolean scored, Integer score, Date upLoadTime) {
        this.assignmentId = assignmentId;
        this.path = path;
        this.scored = scored;
        this.score = score;
        this.upLoadTime = upLoadTime;
    }
}
