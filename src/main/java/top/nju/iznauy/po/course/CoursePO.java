package top.nju.iznauy.po.course;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
public class CoursePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(nullable = false)
    private String courseName;

    @Lob
    @Column(nullable = false, columnDefinition = "text")
    private String courseDescription;

    @Column(nullable = false)
    private String courseCreatorMail; // 创建课程的老师的邮箱

    @Column(nullable = false)
    private boolean hasChecked;

    @Column(nullable = false)
    private boolean hasApproved;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date checkDate;

    public CoursePO(String courseName, String courseDescription, String courseCreatorMail) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCreatorMail = courseCreatorMail;

        this.hasApproved = false;
        this.hasChecked = false;
    }
}
