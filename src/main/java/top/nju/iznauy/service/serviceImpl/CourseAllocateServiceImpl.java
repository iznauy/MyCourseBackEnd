package top.nju.iznauy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.dao.CourseSelectionRecordDao;
import top.nju.iznauy.dao.StudentDao;
import top.nju.iznauy.po.course.CourseReleasePO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.po.courseselection.CourseSelectionRecordPO;
import top.nju.iznauy.po.user.StudentPO;
import top.nju.iznauy.service.CourseAllocateService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 21/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class CourseAllocateServiceImpl implements CourseAllocateService {

    private CourseSelectionDao selectionDao;

    private CourseSelectionRecordDao selectionRecordDao;

    private CourseReleaseDao releaseDao;

    private StudentDao studentDao;

    @Override
    @Transactional
    public void allocateCourseReleaseRandomly(int releaseId) {
        CourseReleasePO releasePO = releaseDao.getCourseReleaseById(releaseId);
        if (releasePO.getQuota() < 1)
            return;
        List<StudentPO> students = studentDao.getStudents(releasePO.getQuota());

        // 更改这门课的选课人数
        releasePO.setCount(students.size());
        releaseDao.saveRelease(releasePO);

        // 生成选课记录
        List<CourseSelectionRecordPO> records = new ArrayList<>();
        students.forEach(e -> records.add(new CourseSelectionRecordPO(releasePO, e.getMail(), true)));
        selectionRecordDao.saveRecords(records);

        // 生成选课列表
        List<CourseSelectionPO> selections = new ArrayList<>();
        students.forEach(e -> selections.add(new CourseSelectionPO(releaseId, e.getMail())));
        selectionDao.saveSelections(selections);
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

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
