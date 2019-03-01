package top.nju.iznauy.dao;

import top.nju.iznauy.po.log.LoginLogPO;
import top.nju.iznauy.po.log.RegisterLogPO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
public interface UserLogDao {

    void addRegisterLog(RegisterLogPO registerLogPO);

    void addLoginLog(LoginLogPO loginLogPO);


}
