package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.exception.NotExistsException;
import top.nju.iznauy.exception.WrongFormatException;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.service.CourseWareService;
import top.nju.iznauy.service.ScoreService;
import top.nju.iznauy.service.tool.ScoreExcelOperations;

import java.util.List;
import java.util.Map;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    private CourseSelectionDao selectionDao;

    private CourseReleaseDao releaseDao;

    @Override
    @Transactional
    public void addReleaseScores(int releaseId, MultipartFile file, boolean publicized) {
        CourseReleasePO releasePO = releaseDao.getCourseReleaseById(releaseId);
        if (releasePO == null)
            throw new NotExistsException("课程发布不存在！");
        List<CourseSelectionPO> selections = selectionDao.getSelectionsByReleaseId(releaseId);

        try {
            Map<String, Integer> scores = ScoreExcelOperations.getScores(file.getName(), file.getInputStream());

            for (CourseSelectionPO selectionPO: selections) {
                Integer score = scores.get(selectionPO.getStudentMail());
                selectionPO.setScore(score);
            }

            selectionDao.saveSelections(selections);

        } catch (Exception e) {
            throw new WrongFormatException();
        }

    }


    @Autowired
    public void setSelectionDao(CourseSelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    @Autowired
    public void setReleaseDao(CourseReleaseDao releaseDao) {
        this.releaseDao = releaseDao;
    }
}
