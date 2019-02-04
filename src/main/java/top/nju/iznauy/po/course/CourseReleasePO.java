package top.nju.iznauy.po.course;

import javax.persistence.*;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Entity
@Table
public class CourseReleasePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = CoursePO.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId")
    private CoursePO course;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int term;

    @Column(nullable = false)
    private int classOrder;

    @Column(nullable = false)
    private boolean hasQuota;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int quota;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasChecked;

    @Column(columnDefinition = "bit(1) default false", nullable = false)
    private boolean hasApproved;

    public CourseReleasePO() {
    }

    public CourseReleasePO(CoursePO course, int year, int term, int classOrder,
                           boolean hasQuota, int quota, boolean hasChecked, boolean hasApproved) {
        this.course = course;
        this.year = year;
        this.term = term;
        this.classOrder = classOrder;
        this.hasQuota = hasQuota;
        this.quota = quota;
        this.hasChecked = hasChecked;
        this.hasApproved = hasApproved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoursePO getCourse() {
        return course;
    }

    public void setCourse(CoursePO course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getClassOrder() {
        return classOrder;
    }

    public void setClassOrder(int classOrder) {
        this.classOrder = classOrder;
    }

    public boolean isHasQuota() {
        return hasQuota;
    }

    public void setHasQuota(boolean hasQuota) {
        this.hasQuota = hasQuota;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
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
