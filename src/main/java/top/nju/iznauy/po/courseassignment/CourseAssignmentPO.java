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

    public CourseAssignmentPO(int courseReleaseId, String name, String description, Date deadLine) {
        this.courseReleaseId = courseReleaseId;
        this.name = name;
        this.description = description;
        this.deadLine = deadLine;
    }
}
