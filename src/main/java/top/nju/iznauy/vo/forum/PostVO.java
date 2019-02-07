package top.nju.iznauy.vo.forum;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.nju.iznauy.entity.UserType;

import java.util.Date;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@AllArgsConstructor
public class PostVO {

    private int id;

    private String creatorEmail;

    private UserType creatorType;

    private String creatorUsername;

    private String creatorAvatar;

    private String title;

    private Date createTime;

    private String content;

}
