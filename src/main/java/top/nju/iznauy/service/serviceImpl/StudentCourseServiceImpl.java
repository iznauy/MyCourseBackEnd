package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.dao.CourseSelectionRecordDao;
import top.nju.iznauy.exception.DuplicationException;
import top.nju.iznauy.exception.NotExistsException;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.po.courseselection.CourseSelectionRecordPO;
import top.nju.iznauy.service.StudentCourseService;
import top.nju.iznauy.vo.student.StudentCourseReleaseBasicInfoVO;
import top.nju.iznauy.vo.student.StudentScoreVO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 22/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
@Slf4j
public class StudentCourseServiceImpl implements StudentCourseService {

    private CourseSelectionDao selectionDao;

    private CourseSelectionRecordDao selectionRecordDao;

    private CourseReleaseDao releaseDao;

    @Override
    public List<StudentCourseReleaseBasicInfoVO> getAvailableCourses(String email) {
        Set<Integer> selections = selectionDao.getSelectionsByUserEmail(email)
                .stream().map(CourseSelectionPO::getCourseReleaseId).collect(Collectors.toSet());

        return releaseDao.getAvailableReleases().stream()
                .filter(CourseReleasePO::available).filter(e -> !selections.contains(e.getId()))
                .map(StudentCourseReleaseBasicInfoVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentCourseReleaseBasicInfoVO> getOwnCourses(String email) {
        Set<Integer> selections = selectionDao.getSelectionsByUserEmail(email)
                .stream().map(CourseSelectionPO::getCourseReleaseId).collect(Collectors.toSet());
        return releaseDao.getReleasesByIds(selections)
                .stream().map(StudentCourseReleaseBasicInfoVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public StudentScoreVO getReleaseScore(String email, int releaseId) {
        CourseSelectionPO selectionPO = selectionDao.getCourseSelectionByCourseReleaseIdAndStudentEmail(releaseId, email);
        Integer score = selectionPO.getScore();

        if (score == null)  // 如果还没有评分过，后面不用看了
            return new StudentScoreVO(false, null, false, null);

        CourseReleasePO releasePO = releaseDao.getCourseReleaseById(releaseId);
        if(releasePO.isPublicizeScore())
            return new StudentScoreVO(true, score, true, releasePO.getScorePath());
         else
            return new StudentScoreVO(true, score, false, null);
    }

    @Override
    @Transactional
    public void selectCourse(String email, int id) {
        CourseReleasePO releasePO = getAndCheckReleasePO(id);
        CourseSelectionPO selectionPO = selectionDao.getCourseSelectionByCourseReleaseIdAndStudentEmail(id, email);
        if (selectionPO != null)
            throw new DuplicationException("已选中该课程");
        CourseSelectionRecordPO recordPO = new CourseSelectionRecordPO(releasePO, email, true);
        releasePO.addCount();
        releaseDao.saveRelease(releasePO);
        selectionRecordDao.saveRecord(recordPO);
        CourseSelectionPO newSelectionPO = new CourseSelectionPO(id, email);
        selectionDao.saveSelection(newSelectionPO);
    }

    @Override
    @Transactional
    public void quitCourse(String email, int id) {
        CourseReleasePO releasePO = getAndCheckReleasePO(id);
        CourseSelectionPO selectionPO = selectionDao.getCourseSelectionByCourseReleaseIdAndStudentEmail(id, email);
        if (selectionPO == null)
            return;
        releasePO.minusCount();
        releaseDao.saveRelease(releasePO);
        CourseSelectionRecordPO recordPO = new CourseSelectionRecordPO(releasePO, email, false);
        selectionRecordDao.saveRecord(recordPO);
        selectionDao.deleteSelection(selectionPO);
    }

    private CourseReleasePO getAndCheckReleasePO(int id) {
        CourseReleasePO releasePO = releaseDao.getCourseReleaseById(id);
        if (releasePO == null)
            throw new NotExistsException("课程不存在");
        return releasePO;
    }

    @Autowired
    public void setSelectionDao(CourseSelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    @Autowired
    public void setSelectionRecordDao(CourseSelectionRecordDao selectionRecordDao) {
        this.selectionRecordDao = selectionRecordDao;
    }

    @Autowired
    public void setReleaseDao(CourseReleaseDao releaseDao) {
        this.releaseDao = releaseDao;
    }
}
