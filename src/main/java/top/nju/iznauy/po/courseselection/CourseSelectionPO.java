package top.nju.iznauy.po.courseselection;

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
@NoArgsConstructor
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

    public CourseSelectionPO(int courseId, int courseReleaseId,
                             String studentMail) {
        this.courseId = courseId;
        this.courseReleaseId = courseReleaseId;
        this.studentMail = studentMail;

        this.score = null;
    }
}
