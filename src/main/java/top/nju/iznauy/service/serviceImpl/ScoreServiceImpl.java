package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.dao.CourseAssignmentDao;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.exception.NotExistsException;
import top.nju.iznauy.exception.ServerUnknownException;
import top.nju.iznauy.exception.WrongFormatException;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.po.courseassignment.CourseAssignmentCommitPO;
import top.nju.iznauy.po.courseassignment.CourseAssignmentPO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.service.ScoreService;
import top.nju.iznauy.service.tool.FileOperations;
import top.nju.iznauy.service.tool.ScoreExcelOperations;

import java.io.File;
import java.io.FileInputStream;
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

    private CourseAssignmentDao assignmentDao;

    @Override
    @Transactional
    public void addReleaseScores(int releaseId, MultipartFile file, boolean publicized) {
        CourseReleasePO releasePO = releaseDao.getCourseReleaseById(releaseId);
        if (releasePO == null)
            throw new NotExistsException("课程发布不存在！");

        String path = FileOperations.saveReleaseScores(file, releaseId);
        if (path == null)
            throw new ServerUnknownException("未知错误");

        releasePO.setPublicizeScore(publicized);
        releasePO.setScorePath(path);
        releaseDao.saveRelease(releasePO);

        List<CourseSelectionPO> selections = selectionDao.getSelectionsByReleaseId(releaseId);

        try {
            File scoreFile = new File(FileOperations.getAbsolutePath(path));
            Map<String, Integer> scores = ScoreExcelOperations
                    .getScores(scoreFile.getName(), new FileInputStream(scoreFile));

            for (CourseSelectionPO selectionPO : selections) {
                Integer score = scores.get(selectionPO.getStudentMail());
                selectionPO.setScore(score);
            }
            selectionDao.saveSelections(selections);

        } catch (Exception e) {
            throw new WrongFormatException();
        }

    }

    @Override
    @Transactional
    public void addAssignmentScores(int assignmentId, MultipartFile file, boolean publicized) {
        CourseAssignmentPO assignmentPO = assignmentDao.getByAssignmentId(assignmentId);
        if (assignmentPO == null)
            throw new NotExistsException("作业不存在！");

        String path = FileOperations.saveAssignmentScores(file, assignmentId);
        if (path == null)
            throw new ServerUnknownException("未知错误");

        assignmentPO.setPublicizeScore(publicized);
        assignmentPO.setScorePath(path);

        List<CourseAssignmentCommitPO> commits = assignmentDao.getCommitsByAssignmentId(assignmentId);

        try {
            File scoreFile = new File(FileOperations.getAbsolutePath(path));
            Map<String, Integer> scores = ScoreExcelOperations
                    .getScores(scoreFile.getName(), new FileInputStream(scoreFile));

            for (CourseAssignmentCommitPO commit : commits) {
                Integer score = scores.get(commit.getUpLoader());
                commit.setScored(true);
                commit.setScore(score);
            }

            assignmentDao.saveAssignmentCommits(commits);
        } catch (Exception e) {
            e.printStackTrace();
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

    @Autowired
    public void setAssignmentDao(CourseAssignmentDao assignmentDao) {
        this.assignmentDao = assignmentDao;
    }
}
