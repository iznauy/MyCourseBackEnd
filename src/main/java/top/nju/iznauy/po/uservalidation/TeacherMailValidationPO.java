package top.nju.iznauy.po.uservalidation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherMailValidationPO {

    @Id
    private String mail;

    @Column(length = 7, nullable = false)
    private String code; // 用户6位数字验证码

}
