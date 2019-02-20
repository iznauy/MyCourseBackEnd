package top.nju.iznauy.service;

import top.nju.iznauy.vo.teacher.TeacherBasicInfoVO;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
public interface TeacherInfoService {

    TeacherBasicInfoVO getBasicInfo(String email);

    void modifyTeacherBasicInfo(String email, String username);

}
