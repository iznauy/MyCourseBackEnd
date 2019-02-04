package top.nju.iznauy.po.courseforum;

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
@EntityListeners(value = AuditingEntityListener.class)
public class CoursePostPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int courseId;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false, columnDefinition="text")
    private String context;

    @Column(nullable = false)
    private String creatorEmail; // 可能是老师，也可能是学生

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private Identity creatorIdentity;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;

    public CoursePostPO() {
    }

    public CoursePostPO(int courseId, String title, String context,
                        String creatorEmail, Identity creatorIdentity) {
        this.courseId = courseId;
        this.title = title;
        this.context = context;
        this.creatorEmail = creatorEmail;
        this.creatorIdentity = creatorIdentity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public Identity getCreatorIdentity() {
        return creatorIdentity;
    }

    public void setCreatorIdentity(Identity creatorIdentity) {
        this.creatorIdentity = creatorIdentity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
