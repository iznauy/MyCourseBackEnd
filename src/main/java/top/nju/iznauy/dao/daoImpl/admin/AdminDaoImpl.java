package top.nju.iznauy.dao.daoImpl.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.AdminDao;
import top.nju.iznauy.po.user.AdminPO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@Repository
public class AdminDaoImpl implements AdminDao {

    private AdminRepository adminRepository;

    @Override
    public AdminPO getAdminByUsername(String username) {
        return adminRepository.findById(username).orElse(null);
    }

    @Override
    public void addAdmin(AdminPO adminPO) {
        adminRepository.save(adminPO);
    }

    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
}
