package top.nju.iznauy.vo.forum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.course.CoursePO;

import java.util.Date;

/**
 * Created on 23/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionVO {

    private String name;

    private int courseId;

    private String description;

    private Date createDate;

    public SectionVO(CoursePO coursePO) {
        name = coursePO.getCourseName();
        courseId = coursePO.getCourseId();
        description = coursePO.getCourseDescription();
        createDate = coursePO.getCreateDate();
    }

}
