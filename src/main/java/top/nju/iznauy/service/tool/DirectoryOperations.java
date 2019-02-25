package top.nju.iznauy.service.tool;

import org.springframework.util.ResourceUtils;
import top.nju.iznauy.service.config.StaticResourceConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created on 25/02/2019.
 * Description:
 *
 * @author iznauy
 */
public class DirectoryOperations {

    private DirectoryOperations() {
    }

    private static void createNewFolder(String base, String newName) {
        try {
            Path assignmentBasePath = Paths.get(ResourceUtils.getURL(base).getPath());
            Path newFolder = assignmentBasePath.resolve(newName);
            Files.createDirectory(newFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCourseFolder(int courseId) {
        createNewFolder(StaticResourceConfig.COURSEWARE_BASE_PATH, "" + courseId);
    }

    public static void createAssignmentFolder(int assignmentId) {
        createNewFolder(StaticResourceConfig.ASSIGNMENT_BASE_PATH, "" + assignmentId);
    }

}
