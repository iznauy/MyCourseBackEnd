package top.nju.iznauy.po.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import top.nju.iznauy.entity.UserType;

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
public class RegisterLogPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String userEmail;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private UserType userType;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date registerDate;

    public RegisterLogPO(String userEmail, UserType userType) {
        this.userEmail = userEmail;
        this.userType = userType;
    }
}
