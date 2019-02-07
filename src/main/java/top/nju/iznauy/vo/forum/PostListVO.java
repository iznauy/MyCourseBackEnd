package top.nju.iznauy.vo.forum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nju.iznauy.entity.UserType;

import java.util.Date;
import java.util.List;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListVO {

    private List<PostListItemVO> posts;

    private int totalPage;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostListItemVO {

        private int id;

        private String creatorEmail;

        private UserType creatorType;

        private String creatorUsername;

        private String creatorAvatar;

        private String title;

        private int replyCount;

        private Date changeTime;
    }

}


