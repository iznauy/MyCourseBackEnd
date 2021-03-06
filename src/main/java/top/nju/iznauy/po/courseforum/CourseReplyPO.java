package top.nju.iznauy.po.courseforum;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
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
@NoArgsConstructor
@Data
public class CourseReplyPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Column(nullable = false)
    private int replyTo;

    public CourseReplyPO(String content, String creatorEmail, UserType creatorIdentity, int replyTo) {
        this.content = content;
        this.creatorEmail = creatorEmail;
        this.creatorIdentity = creatorIdentity;
        this.replyTo = replyTo;
    }
}
