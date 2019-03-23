package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.dao.CourseSelectionRecordDao;
import top.nju.iznauy.dao.TeacherDao;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.po.courseselection.CourseSelectionRecordPO;
import top.nju.iznauy.po.user.TeacherPO;
import top.nju.iznauy.service.StudentStatisticsService;
import top.nju.iznauy.vo.student.CourseSelectionRecordVO;
import top.nju.iznauy.vo.student.StudentStatisticsScoreVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 23/03/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class StudentStatisticsServiceImpl implements StudentStatisticsService {

    private CourseSelectionRecordDao selectionRecordDao;

    private CourseSelectionDao selectionDao;

    private TeacherDao teacherDao;

    private CourseReleaseDao releaseDao;

    @Override
    public List<CourseSelectionRecordVO> getCourseSelectRecords(String email) {
        List<CourseSelectionRecordPO> recordPOs = selectionRecordDao.getRecordsByEmail(email);

        Set<String> teacherEmails = recordPOs.stream().map(CourseSelectionRecordPO::getCourseRelease)
                .map(CourseReleasePO::getCourse).map(CoursePO::getCourseCreatorMail).collect(Collectors.toSet());

        List<TeacherPO> teachers = teacherDao.getTeachersByEmailCollection(teacherEmails);
        Map<String, TeacherPO> teacherMap = new HashMap<>();
        for (TeacherPO teacher: teachers) {
            teacherMap.put(teacher.getMail(), teacher);
        }

        return recordPOs.stream().map(e -> new CourseSelectionRecordVO(e,
                teacherMap.get(e.getCourseRelease().getCourse().getCourseCreatorMail()).getUserName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentStatisticsScoreVO> getCourseScores(String email) {
        List<CourseSelectionPO> selections = selectionDao.getSelectionsByUserEmail(email);
        selections = selections.stream().filter(e -> e.getScore() != null).collect(Collectors.toList());
        List<CourseReleasePO> releases = releaseDao.getReleasesByIds(selections.stream()
                .map(CourseSelectionPO::getCourseReleaseId).collect(Collectors.toList()));
        Map<Integer, String> releaseIdCourseNameMap = new HashMap<>();
        for (CourseReleasePO release: releases) {
            releaseIdCourseNameMap.put(release.getId(), release.getCourse().getCourseName());
        }
        return selections.stream().map(e -> new StudentStatisticsScoreVO(e, releaseIdCourseNameMap.get(e.getCourseReleaseId())))
                .collect(Collectors.toList());
    }

    @Autowired
    public void setSelectionRecordDao(CourseSelectionRecordDao selectionRecordDao) {
        this.selectionRecordDao = selectionRecordDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
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
