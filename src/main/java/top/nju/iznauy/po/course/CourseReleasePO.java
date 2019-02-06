package top.nju.iznauy.po.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int term;

    @Column(nullable = false)
    private int classOrder;

    @Column(nullable = false)
    private boolean hasQuota;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int quota;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasChecked;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasApproved;

}
