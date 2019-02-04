package top.nju.iznauy.po.courseselection;

import javax.persistence.*;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Table
@Entity
public class CourseSelectionPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int courseId;

    @Column(nullable = false)
    private int courseReleaseId;

    @Column(nullable = false)
    private String studentMail;

    @Column
    private Integer score;

    public CourseSelectionPO() {
    }

    public CourseSelectionPO(int courseId, int courseReleaseId,
                             String studentMail, Integer score) {
        this.courseId = courseId;
        this.courseReleaseId = courseReleaseId;
        this.studentMail = studentMail;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseReleaseId() {
        return courseReleaseId;
    }

    public void setCourseReleaseId(int courseReleaseId) {
        this.courseReleaseId = courseReleaseId;
    }

    public String getStudentMail() {
        return studentMail;
    }

    public void setStudentMail(String studentMail) {
        this.studentMail = studentMail;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
