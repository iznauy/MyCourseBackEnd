package top.nju.iznauy.vo.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created on 24/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDetailVO {

    private int id;

    private String name;

    private String description;

    private Date deadLine;

}
