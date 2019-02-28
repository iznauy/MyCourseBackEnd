package top.nju.iznauy.po.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 28/02/2019.
 * Description:
 *
 * @author iznauy
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class BroadCastingPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int releaseId;

    @Column(nullable = false)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;

    public BroadCastingPO(int releaseId, String content) {
        this.releaseId = releaseId;
        this.content = content;
    }
}
