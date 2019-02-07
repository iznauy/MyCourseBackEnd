package top.nju.iznauy.dao.daoImpl.forum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.nju.iznauy.po.courseforum.CourseReplyPO;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseReplyRepository extends JpaRepository<CourseReplyPO, Integer>,
        JpaSpecificationExecutor<CourseReplyPO> {
}
