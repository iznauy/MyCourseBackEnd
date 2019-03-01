package top.nju.iznauy.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import top.nju.iznauy.dao.CourseReleaseDao;
import top.nju.iznauy.dao.CourseSelectionDao;
import top.nju.iznauy.dao.StudentDao;
import top.nju.iznauy.po.course.CoursePO;
import top.nju.iznauy.po.courseselection.CourseSelectionPO;
import top.nju.iznauy.po.user.StudentPO;
import top.nju.iznauy.service.tool.MailService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 28/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Component
@Slf4j
public class MailBroadCastingService {

    private CourseSelectionDao selectionDao;

    private StudentDao studentDao;

    private CourseReleaseDao releaseDao;

    private MailService mailService;

    private List<StudentPO> getReleaseStudents(int releaseId) {
        List<String> students = selectionDao.getSelectionsByReleaseId(releaseId).stream()
                .map(CourseSelectionPO::getStudentMail).collect(Collectors.toList());
        return studentDao.getStudentsByEmailCollection(students);
    }

    @Async
    public void sendBroadCasting(int releaseId, String content) {
        // 群发邮件
        CoursePO coursePO = releaseDao.getCourseReleaseById(releaseId).getCourse();
        List<StudentPO> studentPOS = getReleaseStudents(releaseId);

        for (StudentPO student : studentPOS) {
            String title = "来自课程《" + coursePO.getCourseName() + "》的通知";
            mailService.sentMail(student.getMail(), title, content);
        }
        log.info("群发邮件结束！");
    }

    @Autowired
    public void setSelectionDao(CourseSelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setReleaseDao(CourseReleaseDao releaseDao) {
        this.releaseDao = releaseDao;
    }

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }
}
