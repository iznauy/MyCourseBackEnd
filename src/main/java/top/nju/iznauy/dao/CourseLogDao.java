package top.nju.iznauy.dao;

import top.nju.iznauy.po.log.CourseCreateLogPO;
import top.nju.iznauy.po.log.CourseReleaseLogPO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
public interface CourseLogDao {

    void addCreateLog(CourseCreateLogPO createLogPO);

    void addReleaseCourseLog(CourseReleaseLogPO releaseLogPO);

}
