package top.nju.iznauy.vo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.course.CoursePO;

import java.util.Date;

/**
 * Created on 21/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUncheckedCourseVO {

    private int id;

    private String name;

    private String description;

    private Date createDate;

    private String creatorEmail;

    public AdminUncheckedCourseVO(CoursePO coursePO) {
        id = coursePO.getCourseId();
        name = coursePO.getCourseName();
        description = coursePO.getCourseDescription();
        createDate = coursePO.getCreateDate();
        creatorEmail = coursePO.getCourseCreatorMail();
    }

}
