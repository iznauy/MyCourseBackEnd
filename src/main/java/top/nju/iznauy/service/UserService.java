package top.nju.iznauy.service;

import top.nju.iznauy.vo.TokenVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface UserService {

    TokenVO login(String email, String password);

    void register(String email, String password);

    void sendValidationCode(String email);

    TokenVO validateUser(String email, String code);

}
