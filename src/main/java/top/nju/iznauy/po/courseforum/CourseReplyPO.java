package top.nju.iznauy.po.courseforum;

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

    @ManyToOne(targetEntity = CoursePostPO.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "replyTo")
    private CoursePostPO replyTo;

    public CourseReplyPO(String context, String creatorEmail,
                         Identity creatorIdentity, Date createTime, CoursePostPO replyTo) {
        this.context = context;
        this.creatorEmail = creatorEmail;
        this.creatorIdentity = creatorIdentity;
        this.createTime = createTime;
        this.replyTo = replyTo;
    }
}
