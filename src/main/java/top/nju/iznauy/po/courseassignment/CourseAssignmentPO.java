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
public class CourseAssignmentPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int courseReleaseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date deadLine;

    public CourseAssignmentPO() {
    }

    public CourseAssignmentPO(int courseReleaseId, String name, String description, Date deadLine) {
        this.courseReleaseId = courseReleaseId;
        this.name = name;
        this.description = description;
        this.deadLine = deadLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseReleaseId() {
        return courseReleaseId;
    }

    public void setCourseReleaseId(int courseReleaseId) {
        this.courseReleaseId = courseReleaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }
}
