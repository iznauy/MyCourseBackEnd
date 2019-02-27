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
public class ClassStudentVO {

    private String number;

    private String email;

    private String name;

    private String avatar;

    public ClassStudentVO(StudentPO po) {
        number = po.getNumber();
        email = po.getMail();
        name = po.getUserName();
        avatar = po.getAvatar();
    }

}
