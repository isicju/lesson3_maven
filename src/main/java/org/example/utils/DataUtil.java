package org.example.utils;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DataUtil {

    public static byte[] getFileAsByteArray(String filePath) {
        try (InputStream resource = DataUtil.class.getClassLoader().getResourceAsStream(filePath)) {
            return IOUtils.toByteArray(resource);
        } catch (Exception e) {
            return new byte[]{};
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
