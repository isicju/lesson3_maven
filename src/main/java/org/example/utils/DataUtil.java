package org.example.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

public class DataUtil {

    public static byte[] getFileAsByteArray(String filePath) {
        File file = getFileByPath(filePath);
        try {
            return Files.readAllBytes(file.toPath());
        } catch (Exception e) {
            return null;
        }
    }

    public static File getFileByPath(String filePath) {
        try {
            URL resource = DataUtil.class.getClassLoader().getResource(filePath);
            return new File(resource.toURI());
        } catch (Exception e) {
            return null;
        }
    }

    public static String getFileAsString(String filePath) {
        File file = getFileByPath(filePath);
        try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

}
