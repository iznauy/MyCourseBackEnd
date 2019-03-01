package top.nju.iznauy.vo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentScoreVO {

    private boolean scored;

    private Integer score;

    private boolean publicized;

    private String path;

}
