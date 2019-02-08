package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.controller.tools.JwtTokenUtils;
import top.nju.iznauy.dao.AdminDao;
import top.nju.iznauy.entity.UserType;
import top.nju.iznauy.exception.IncorrectAccountException;
import top.nju.iznauy.po.user.AdminPO;
import top.nju.iznauy.service.AdminService;
import top.nju.iznauy.vo.TokenVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    @Override
    public TokenVO login(String username, String password) {
        AdminPO adminPO = adminDao.getAdminByUsername(username);
        if (adminPO == null)
            throw new IncorrectAccountException("账号不存在");
        if (!adminPO.getPassword().equals(password))
            throw new IncorrectAccountException("密码错误");

        String token = JwtTokenUtils.createToken(username, UserType.admin);
        return new TokenVO(token);
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
}
