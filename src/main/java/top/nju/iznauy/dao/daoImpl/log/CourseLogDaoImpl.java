package top.nju.iznauy.dao.daoImpl.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseLogDao;
import top.nju.iznauy.po.log.CourseCreateLogPO;
import top.nju.iznauy.po.log.CourseReleaseLogPO;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Repository
public class CourseLogDaoImpl implements CourseLogDao {

    private CourseCreateLogRepository courseCreateLogRepository;

    private CourseReleaseLogRepository releaseLogRepository;

    @Override
    public void addCreateLog(CourseCreateLogPO createLogPO) {
        courseCreateLogRepository.save(createLogPO);
    }

    @Override
    public void addReleaseCourseLog(CourseReleaseLogPO releaseLogPO) {
        releaseLogRepository.save(releaseLogPO);
    }

    @Autowired
    public void setCourseCreateLogRepository(CourseCreateLogRepository courseCreateLogRepository) {
        this.courseCreateLogRepository = courseCreateLogRepository;
    }

    @Autowired
    public void setReleaseLogRepository(CourseReleaseLogRepository releaseLogRepository) {
        this.releaseLogRepository = releaseLogRepository;
    }
}
