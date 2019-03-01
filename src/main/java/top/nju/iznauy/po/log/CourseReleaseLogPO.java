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
public class CourseReleaseLogPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

    @Column(nullable = false)
    private int releaseId;

    @Column(nullable = false)
    private String creatorEmail;

    public CourseReleaseLogPO(int releaseId, String creatorEmail) {
        this.releaseId = releaseId;
        this.creatorEmail = creatorEmail;
    }
}
