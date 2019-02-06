package top.nju.iznauy.service;

import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.vo.AvatarVO;
import top.nju.iznauy.vo.StudentBasicInfoVO;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface StudentInfoService {

    void logOff(String email);

    StudentBasicInfoVO getBasicInfo(String email);

    void modifyStudentBasicInfo(String email, String username, String number);

    AvatarVO getAvatar(String email);

    void uploadAvatar(String email, MultipartFile avatar);

}
