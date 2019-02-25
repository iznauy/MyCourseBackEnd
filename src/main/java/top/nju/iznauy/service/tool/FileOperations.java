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
 * TODO: 这个类之中的方法需要被重写，因为太脆弱了，而且私有方法其实只对头像的存储有效
 *
 * @author iznauy
 */
public class FileOperations {

    private static String storeMultipartFile(Path basePath, MultipartFile file, String name) throws IOException {
        Path targetPath = basePath.resolve(name);
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        return basePath.getParent().getParent().relativize(targetPath).normalize().toString(); // 这个方法非常的危险
    }

    private static String getExtension(MultipartFile file) {
        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
    }

    public static String saveAvatar(MultipartFile avatar, String email) {
        String filename = email.split("@")[0] + "." + getExtension(avatar); // 前面的部分当成名字
        String avatarPath;
        try {
            Path path = Paths.get(ResourceUtils.getURL(StaticResourceConfig.AVATAR_BASE_PATH).getPath());
            avatarPath = storeMultipartFile(path, avatar, filename);
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
            Path path = Paths.get(ResourceUtils.getURL(StaticResourceConfig.COURSEWARE_BASE_PATH).getPath());
            warePath = storeMultipartFile(path, ware, filename);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServerUnknownException("未知错误");
        }
        return warePath;
    }

    public static String saveCourseAssignmentCommit(MultipartFile file, int assignmentId, String email) {
        return null;
    }

}
