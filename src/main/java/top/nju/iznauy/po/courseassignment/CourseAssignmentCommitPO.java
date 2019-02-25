package top.nju.iznauy.po.courseassignment;

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
@NoArgsConstructor
public class CourseAssignmentCommitPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int assignmentId;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private boolean scored;

    @Column(nullable = false)
    private String upLoader;

    @Column
    private Integer score;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date upLoadTime;

    public CourseAssignmentCommitPO(int assignmentId, String path, String upLoader, Date upLoadTime) {
        this.assignmentId = assignmentId;
        this.path = path;
        this.upLoader = upLoader;
        this.scored = false;
        this.score = null;
        this.upLoadTime = upLoadTime;
    }
}
