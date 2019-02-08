package top.nju.iznauy.po.course;

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
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
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

}
