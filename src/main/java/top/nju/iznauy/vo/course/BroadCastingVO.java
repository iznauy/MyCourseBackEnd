package top.nju.iznauy.vo.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.nju.iznauy.po.course.BroadCastingPO;

import java.util.Date;

/**
 * Created on 28/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Data
@AllArgsConstructor
public class BroadCastingVO {

    private int id;

    private String content;

    private Date lastModified;

    public BroadCastingVO(BroadCastingPO po) {
        id = po.getId();
        content = po.getContent();
        lastModified = po.getCreateTime();
    }

    public BroadCastingVO() {
        this.id = 0;
        this.content = null;
        this.lastModified = null;
    }
}
