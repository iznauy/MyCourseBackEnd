package top.nju.iznauy.po.course;

import lombok.AllArgsConstructor;
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
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class CourseReleasePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = CoursePO.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId")
    private CoursePO course;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date beginDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private int classOrder;

    @Column(nullable = false)
    private boolean hasQuota;

    @Column(nullable = false)
    private int quota;

    @Column(nullable = false)
    private boolean hasChecked;

    @Column(nullable = false)
    private boolean hasApproved;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

    public CourseReleasePO(CoursePO course, Date beginDate, Date endDate, int classOrder, boolean hasQuota, int quota) {
        this.course = course;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.classOrder = classOrder;
        this.hasQuota = hasQuota;
        if (hasQuota)
            this.quota = quota;
        else
            this.quota = 0;

        hasChecked = false;
        hasApproved = false;
    }
}
