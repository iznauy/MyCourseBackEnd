package top.nju.iznauy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.nju.iznauy.dao.AdminDao;
import top.nju.iznauy.po.user.AdminPO;

/**
 * Created on 21/02/2019.
 * Description:
 *
 * @author iznauy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTests {

    @Autowired
    public AdminDao dao;

    @Test
    public void addAdmin() {
        AdminPO adminPO = new AdminPO("admin", "12345");
        dao.addAdmin(adminPO);
    }

}
