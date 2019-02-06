package top.nju.iznauy.service;

import top.nju.iznauy.vo.TokenVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface AdminService {

    TokenVO login(String username, String password);

}
