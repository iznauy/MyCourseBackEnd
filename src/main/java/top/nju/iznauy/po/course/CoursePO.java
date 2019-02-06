package top.nju.iznauy.po.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Table
@Entity
@Data
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

    public CoursePO(String courseName, String courseDescription, String courseCreatorMail) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCreatorMail = courseCreatorMail;

        this.hasApproved = false;
        this.hasChecked = false;
    }
}
