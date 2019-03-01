package top.nju.iznauy.dao;

import top.nju.iznauy.po.log.PosterLogPO;
import top.nju.iznauy.po.log.ReplyLogPO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
public interface ForumLogDao {

    void addPosterLog(PosterLogPO logPO);

    void addReplyLog(ReplyLogPO logPO);

}
