package top.nju.iznauy.po.courseforum;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import top.nju.iznauy.entity.UserType;

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
@Data
@NoArgsConstructor
public class CoursePostPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int courseId;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(nullable = false)
    private String creatorEmail; // 可能是老师，也可能是学生

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private UserType creatorIdentity;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date changeTime;

    @Column(nullable = false)
    private int replyCount;

    public CoursePostPO(int courseId, String title, String content,
                        String creatorEmail, UserType creatorIdentity) {
        this.courseId = courseId;
        this.title = title;
        this.content = content;
        this.creatorEmail = creatorEmail;
        this.creatorIdentity = creatorIdentity;
        this.replyCount = 0;
    }

    public void addReply() {
        this.replyCount += 1;
    }

}
