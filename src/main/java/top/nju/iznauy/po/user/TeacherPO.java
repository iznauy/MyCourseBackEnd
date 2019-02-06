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
@Entity
@Table
@Data
@NoArgsConstructor
public class TeacherPO {

    @Id
    private String mail;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private boolean hasValidated;

    public TeacherPO(String mail, String password) {
        this.mail = mail;
        this.password = password;

        this.userName = mail.split("@")[0];
        this.hasValidated = false;
        this.avatar = AvatarRandomGenerator.randomGenerateTeacherAvatar();
    }
}
