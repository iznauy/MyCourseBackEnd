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
@Table
@Entity
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

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasValidated;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasCancelled;

    public StudentPO() {
    }

    /**
     * 主要是提供给注册的时候
     * @param mail
     * @param password
     */
    public StudentPO(String mail, String password) {
        this.mail = mail;
        this.userName = mail.split("@")[0]; // 用户名前面的部分自动作为学号
        this.password = password;

        this.avatar = AvatarRandomGenerator.randomGenerateStudentAvatar();
        this.number = null;
        this.hasValidated = false;
        this.hasCancelled = false;
    }

    public StudentPO(String mail, String userName, String password, String avatar,
                     String number, boolean hasValidated, boolean hasCancelled) {
        this.mail = mail;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
        this.number = number;
        this.hasValidated = hasValidated;
        this.hasCancelled = hasCancelled;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isHasValidated() {
        return hasValidated;
    }

    public void setHasValidated(boolean hasValidated) {
        this.hasValidated = hasValidated;
    }

    public boolean isHasCancelled() {
        return hasCancelled;
    }

    public void setHasCancelled(boolean hasCancelled) {
        this.hasCancelled = hasCancelled;
    }
}
