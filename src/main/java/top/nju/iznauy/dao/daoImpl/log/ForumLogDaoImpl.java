package top.nju.iznauy.dao.daoImpl.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.ForumLogDao;
import top.nju.iznauy.po.log.PosterLogPO;
import top.nju.iznauy.po.log.ReplyLogPO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class ForumLogDaoImpl implements ForumLogDao {

    private PosterLogRepository posterLogRepository;

    private ReplyLogRepository replyLogRepository;

    @Override
    public void addPosterLog(PosterLogPO logPO) {
        posterLogRepository.save(logPO);
    }

    @Override
    public void addReplyLog(ReplyLogPO logPO) {
        replyLogRepository.save(logPO);
    }

    @Autowired
    public void setPosterLogRepository(PosterLogRepository posterLogRepository) {
        this.posterLogRepository = posterLogRepository;
    }

    @Autowired
    public void setReplyLogRepository(ReplyLogRepository replyLogRepository) {
        this.replyLogRepository = replyLogRepository;
    }
}
