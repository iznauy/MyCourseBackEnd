package top.nju.iznauy.po.courseselection;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import top.nju.iznauy.po.course.CourseReleasePO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Entity
@Table
@EntityListeners(value = AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class CourseSelectionRecordPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = CourseReleasePO.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "courseReleaseId")
    private CourseReleasePO courseRelease;

    @Column(nullable = false)
    private String studentEmail;

    @Column(nullable = false)
    private boolean isSelect;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date operateTime;

    public CourseSelectionRecordPO(CourseReleasePO courseRelease, String studentEmail, boolean isSelect, Date operateTime) {
        this.courseRelease = courseRelease;
        this.studentEmail = studentEmail;
        this.isSelect = isSelect;
        this.operateTime = operateTime;
    }
}
