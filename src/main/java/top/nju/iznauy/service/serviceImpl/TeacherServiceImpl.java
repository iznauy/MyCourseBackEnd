package top.nju.iznauy.service.serviceImpl;

import org.springframework.stereotype.Service;
import top.nju.iznauy.service.UserService;
import top.nju.iznauy.vo.TokenVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service("teacherService")
public class TeacherServiceImpl implements UserService {

    @Override
    public TokenVO login(String email, String password) {
        return null;
    }

    @Override
    public void register(String email, String password) {

    }

    @Override
    public void sendValidationCode(String email) {

    }

    @Override
    public TokenVO validateUser(String email, String code) {
        return null;
    }
}
