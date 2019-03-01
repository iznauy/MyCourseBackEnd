package top.nju.iznauy.po.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class CourseCreateLogPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

    @Column(nullable = false)
    private int courseId;

    @Column(nullable = false)
    private String creatorEmail;

    public CourseCreateLogPO(int courseId, String creatorEmail) {
        this.courseId = courseId;
        this.creatorEmail = creatorEmail;
    }
}
