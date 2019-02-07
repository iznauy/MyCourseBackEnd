package top.nju.iznauy.po.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.tools.AvatarRandomGenerator;

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
@Data
@NoArgsConstructor
public class StudentPO {

    @Id
    private String mail;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String avatar;

    @Column
    private String number; // 学号，可以为空

    @Column(nullable = false)
    private boolean hasValidated;

    @Column(nullable = false)
    private boolean hasCancelled;

    /**
     * 主要是提供给注册的时候
     *
     * @param mail
     * @param password
     */
    public StudentPO(String mail, String password) {
        this.mail = mail;
        this.userName = mail.split("@")[0]; // 邮箱前面的部分自动作为学号和用户名
        this.password = password;

        this.avatar = AvatarRandomGenerator.randomGenerateStudentAvatar();
        this.number = userName;
        this.hasValidated = false;
        this.hasCancelled = false;
    }
}
