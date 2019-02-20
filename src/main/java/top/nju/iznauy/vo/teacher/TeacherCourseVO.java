package top.nju.iznauy.vo.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created on 18/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCourseVO {

    private int id;

    private String name;

    private String description;

    private boolean approve;

    private boolean check;

    private Date createDate;

}
