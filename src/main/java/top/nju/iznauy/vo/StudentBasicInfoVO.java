package top.nju.iznauy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBasicInfoVO {

    private String email;

    private String username;

    private String number;

    private String avatar;

}
