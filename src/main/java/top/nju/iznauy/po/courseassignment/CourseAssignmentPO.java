package top.nju.iznauy.po.courseassignment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
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

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

    @Column(nullable = false)
    private boolean publicizeScore;

    @Column
    private String scorePath;

    public CourseAssignmentPO(int courseReleaseId, String name, String description, Date deadLine) {
        this.courseReleaseId = courseReleaseId;
        this.name = name;
        this.description = description;
        this.deadLine = deadLine;
        this.publicizeScore = false;
    }
}
