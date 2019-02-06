package top.nju.iznauy.po.courseware;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Table
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@Data
public class CourseWarePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int courseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String path;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean deleted = false;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date upLoadTime;

    public CourseWarePO(int courseId, String name, String path, boolean deleted) {
        this.courseId = courseId;
        this.name = name;
        this.path = path;
        this.deleted = deleted;
    }
}
