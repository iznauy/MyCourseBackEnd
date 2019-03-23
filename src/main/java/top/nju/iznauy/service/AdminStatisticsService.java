package top.nju.iznauy.service;

import top.nju.iznauy.vo.admin.AccountCountVO;
import top.nju.iznauy.vo.admin.CourseCountVO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
public interface AdminStatisticsService {

    AccountCountVO accountRecord();

    CourseCountVO courseAndReleaseRecord();


}
