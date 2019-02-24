package top.nju.iznauy.vo.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.courseware.CourseWarePO;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseWareVO {

    private int id;

    private String name;

    private String path;

    public CourseWareVO(CourseWarePO po) {
        id = po.getId();
        name = po.getName();
        path = po.getPath();
    }

}
