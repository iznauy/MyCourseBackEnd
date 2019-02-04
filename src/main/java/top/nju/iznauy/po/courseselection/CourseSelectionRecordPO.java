package top.nju.iznauy.po.courseselection;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import top.nju.iznauy.po.course.CourseReleasePO;

import javax.persistence.*;
import java.sql.Timestamp;
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
public class CourseSelectionRecordPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int key;

    @ManyToOne(targetEntity = CourseReleasePO.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "courseReleaseId")
    private CourseReleasePO courseRelease;

    @Column(nullable = false)
    private String studentEmail;

    @Column(columnDefinition = "bit(1) default false", nullable = true)
    private boolean isSelect;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date operateTime;

    public CourseSelectionRecordPO() {
    }

    public CourseSelectionRecordPO(CourseReleasePO courseRelease, String studentEmail, boolean isSelect, Date operateTime) {
        this.courseRelease = courseRelease;
        this.studentEmail = studentEmail;
        this.isSelect = isSelect;
        this.operateTime = operateTime;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public CourseReleasePO getCourseRelease() {
        return courseRelease;
    }

    public void setCourseRelease(CourseReleasePO courseRelease) {
        this.courseRelease = courseRelease;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
