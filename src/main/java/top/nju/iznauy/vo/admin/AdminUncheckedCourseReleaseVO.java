package top.nju.iznauy.vo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.course.CourseReleasePO;

import java.util.Date;

/**
 * Created on 21/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUncheckedCourseReleaseVO {

    private int id;

    private String courseName;

    private Date createDate;

    private Date beginDate;

    private Date endDate;

    private int classOrder;

    private String creatorEmail;

    private boolean hasQuota;

    private int quota;

    public AdminUncheckedCourseReleaseVO(CourseReleasePO courseReleasePO) {
        id = courseReleasePO.getId();
        courseName = courseReleasePO.getCourse().getCourseName();
        createDate = courseReleasePO.getCreateDate();
        beginDate = courseReleasePO.getBeginDate();
        endDate = courseReleasePO.getEndDate();
        classOrder = courseReleasePO.getClassOrder();
        creatorEmail = courseReleasePO.getCourse().getCourseCreatorMail();
        hasQuota = courseReleasePO.isHasQuota();
        quota = courseReleasePO.getQuota();
    }

}
