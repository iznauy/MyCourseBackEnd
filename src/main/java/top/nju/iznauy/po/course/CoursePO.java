package top.nju.iznauy.po.course;

import javax.persistence.*;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Table
@Entity
public class CoursePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(nullable = false)
    private String courseName;

    @Lob
    @Column(nullable = false, columnDefinition="text")
    private String courseDescription;

    @Column(nullable = false)
    private String courseCreatorMail; // 创建课程的老师的邮箱

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasChecked;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasApproved;

    public CoursePO() {
    }

    public CoursePO(String courseName, String courseDescription, String courseCreatorMail) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCreatorMail = courseCreatorMail;

        this.hasApproved = false;
        this.hasChecked = false;

    }

    public CoursePO(int courseId, String courseName,
                    String courseDescription, String courseCreatorMail, boolean hasChecked, boolean hasApproved) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCreatorMail = courseCreatorMail;
        this.hasChecked = hasChecked;
        this.hasApproved = hasApproved;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseCreatorMail() {
        return courseCreatorMail;
    }

    public void setCourseCreatorMail(String courseCreatorMail) {
        this.courseCreatorMail = courseCreatorMail;
    }

    public boolean isHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(boolean hasChecked) {
        this.hasChecked = hasChecked;
    }

    public boolean isHasApproved() {
        return hasApproved;
    }

    public void setHasApproved(boolean hasApproved) {
        this.hasApproved = hasApproved;
    }
}
