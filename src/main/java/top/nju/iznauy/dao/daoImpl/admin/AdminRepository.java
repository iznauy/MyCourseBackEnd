package top.nju.iznauy.dao.daoImpl.admin;

import org.springframework.data.repository.CrudRepository;
import top.nju.iznauy.po.user.AdminPO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface AdminRepository extends CrudRepository<AdminPO, String> {
}
