package top.nju.iznauy.vo.forum;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.nju.iznauy.entity.UserType;

import java.util.Date;
import java.util.List;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
@AllArgsConstructor
@Data
public class ReplyListVO {

    private List<ReplyListItemVO> replies;

    private int totalPage;


    @AllArgsConstructor
    @Data
    public static class ReplyListItemVO {

        private int id;

        private String creatorEmail;

        private UserType creatorType;

        private String creatorUsername;

        private String creatorAvatar;

        private String content;

        private Date createTime;

    }

}
