package top.nju.iznauy.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
public interface ScoreService {

    void addReleaseScores(int releaseId, MultipartFile file, boolean publicized);

    void addAssignmentScores(int assignmentId, MultipartFile file, boolean publicized);

}
