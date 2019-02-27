package top.nju.iznauy.vo.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.po.user.StudentPO;

/**
 * Created on 27/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassmateVO {

    private String name;

    private String avatar;

    public ClassmateVO(StudentPO studentPO) {
        name = studentPO.getUserName();
        avatar = studentPO.getAvatar();
    }

}
