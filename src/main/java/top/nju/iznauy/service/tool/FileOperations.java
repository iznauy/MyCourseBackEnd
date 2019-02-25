package top.nju.iznauy.service.tool;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import top.nju.iznauy.exception.ServerUnknownException;
import top.nju.iznauy.service.config.StaticResourceConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created on 06/02/2019.
 * Description:
 * 里面的方法还是很脆弱，而且没有经过很充分的测试。
 *
 * @author iznauy
 */
public class FileOperations {


    private static String getExtension(MultipartFile file) {
        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
    }

    public static String saveAvatar(MultipartFile avatar, String email) {
        String filename = email.split("@")[0] + "." + getExtension(avatar); // 前面的部分当成名字
        String avatarPath;
        try {
            Path path = Paths.get(ResourceUtils.getURL(StaticResourceConfig.AVATAR_BASE_PATH).getPath());
            Path targetPath = path.resolve(filename);
            Files.copy(avatar.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            avatarPath = path.getParent().getParent().relativize(targetPath).normalize().toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServerUnknownException("未知错误");
        }
        return avatarPath;
    }

    public static String saveCourseWare(MultipartFile ware, int courseId, String name) {
        String filename = "" + courseId + "_" + name + "_" + System.currentTimeMillis() + "." + getExtension(ware);
        String warePath;
        try {
            Path basePath = Paths.get(ResourceUtils.getURL(StaticResourceConfig.COURSEWARE_BASE_PATH).getPath());
            Path path = basePath.resolve(courseId + "");
            Path targetPath = path.resolve(filename);
            Files.copy(ware.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            warePath = basePath.getParent().getParent().relativize(targetPath).normalize().toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServerUnknownException("未知错误");
        }
        return warePath;
    }

    public static String saveCourseAssignmentCommit(MultipartFile file, int assignmentId, String email) {
        String filename = email.split("@")[0] + "." + getExtension(file);
        String assignmentPath;
        try {
            Path basePath = Paths.get(ResourceUtils.getURL(StaticResourceConfig.ASSIGNMENT_BASE_PATH).getPath());
            Path path = basePath.resolve("" + assignmentId);
            Path targetPath = path.resolve(filename);
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            assignmentPath = basePath.getParent().getParent().relativize(targetPath).normalize().toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServerUnknownException("未知错误");
        }
        return assignmentPath;
    }

}
