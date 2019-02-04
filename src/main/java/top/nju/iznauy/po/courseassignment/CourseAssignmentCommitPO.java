package top.nju.iznauy.po.courseassignment;

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


    public CourseAssignmentCommitPO() {
    }

    public CourseAssignmentCommitPO(int assignmentId, String path, boolean scored, Integer score, Date upLoadTime) {
        this.assignmentId = assignmentId;
        this.path = path;
        this.scored = scored;
        this.score = score;
        this.upLoadTime = upLoadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getUpLoadTime() {
        return upLoadTime;
    }

    public void setUpLoadTime(Date upLoadTime) {
        this.upLoadTime = upLoadTime;
    }
}
