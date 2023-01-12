package org.example.utils;

import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DataUtil {
    public static byte[] getFileAsByteArray(String filePath) {
        try (InputStream resource = DataUtil.class.getClassLoader().getResourceAsStream(filePath)) {
            return IOUtils.toByteArray(resource);
        } catch (Exception e) {
            return new byte[]{};
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
        byte[] file = getFileAsByteArray(filePath);
        try {
            return new String(file, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }
}
