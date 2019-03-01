package top.nju.iznauy.dao.daoImpl.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.UserLogDao;
import top.nju.iznauy.po.log.LoginLogPO;
import top.nju.iznauy.po.log.RegisterLogPO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class UserLogDaoImpl implements UserLogDao {

    private LoginLogRepository loginLogRepository;

    private RegisterLogRepository registerLogRepository;

    @Override
    public void addRegisterLog(RegisterLogPO registerLogPO) {
        registerLogRepository.save(registerLogPO);
    }

    @Override
    public void addLoginLog(LoginLogPO loginLogPO) {
        loginLogRepository.save(loginLogPO);
    }

    @Autowired
    public void setLoginLogRepository(LoginLogRepository loginLogRepository) {
        this.loginLogRepository = loginLogRepository;
    }

    @Autowired
    public void setRegisterLogRepository(RegisterLogRepository registerLogRepository) {
        this.registerLogRepository = registerLogRepository;
    }
}
