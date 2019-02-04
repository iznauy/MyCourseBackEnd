package top.nju.iznauy.po.uservalidation;

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
public class StudentMailValidationPO {

    @Id
    private String mail;

    @Column(length = 7, nullable = false)
    private String code; // 用户6位数字验证码

    public StudentMailValidationPO() {
    }

    public StudentMailValidationPO(String mail, String code) {
        this.mail = mail;
        this.code = code;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
