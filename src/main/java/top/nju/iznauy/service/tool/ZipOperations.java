package top.nju.iznauy.service.tool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import top.nju.iznauy.exception.ServerUnknownException;
import top.nju.iznauy.service.config.StaticResourceConfig;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created on 25/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
public class ZipOperations {

    private ZipOperations() {
    }

    private static void zip(String targetFile, String rawDirectory) throws IOException {
        File target = new File(targetFile);
        if (!target.exists())
            if (!target.createNewFile())
                throw new RuntimeException("创建文件失败");
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(target));
        BufferedOutputStream out = new BufferedOutputStream(zipOut);
        File rawDir = new File(rawDirectory);
        File[] items = rawDir.listFiles();
        for (File item : items) {
            zipOut.putNextEntry(new ZipEntry(item.getName()));
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(item));
            int tag;
            while ((tag = in.read()) != -1)
                out.write(tag);
        }
        out.close();
        zipOut.close();
        log.info("压缩完毕");
    }

    public static String assignmentFolderToZip(int assignmentId) {
        String result = null;
        try {
            Path path = Paths.get(ResourceUtils.getURL(StaticResourceConfig.ASSIGNMENT_BASE_PATH).getPath()).normalize();
            Path targetFile = path.resolve("" + assignmentId + ".zip").normalize();
            Path rawDirectory = path.resolve("" + assignmentId).normalize();
            zip(targetFile.toString(), rawDirectory.toString());
            result = targetFile.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServerUnknownException("未知错误");
        }
        return result;
    }

}
