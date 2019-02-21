package top.nju.iznauy.dao;

import top.nju.iznauy.po.user.AdminPO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface AdminDao {

    AdminPO getAdminByUsername(String username);

    void addAdmin(AdminPO adminPO);

}
