package top.nju.iznauy.po.courseselection;

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
@EntityListeners(value = AuditingEntityListener.class)
@NoArgsConstructor
public class CourseSelectionPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int courseReleaseId;

    @Column(nullable = false)
    private String studentMail;

    @Column
    private Integer score;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date scoreDate;

    public CourseSelectionPO(int courseReleaseId,
                             String studentMail) {
        this.courseReleaseId = courseReleaseId;
        this.studentMail = studentMail;

        this.score = null;
    }
}
