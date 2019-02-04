package top.nju.iznauy.po.user;

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
public class TeacherPO {

    @Id
    private String mail;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String avatar;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasValidated;

    public TeacherPO() {
    }

    public TeacherPO(String mail, String password) {
        this.mail = mail;
        this.password = password;

        this.userName = mail.split("@")[0];
        this.hasValidated = false;
        this.avatar = AvatarRandomGenerator.randomGenerateTeacherAvatar();
    }

    public TeacherPO(String mail, String userName, String password,
                     String avatar, boolean hasValidated) {
        this.mail = mail;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
        this.hasValidated = hasValidated;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isHasValidated() {
        return hasValidated;
    }

    public void setHasValidated(boolean hasValidated) {
        this.hasValidated = hasValidated;
    }
}
