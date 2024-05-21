package com.aiassistant.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtils {

    public static List<File> unzip(File zipFile, String destDir) throws IOException {
        List<File> files = new ArrayList<>();
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = new File(destDir + File.separator + zipEntry.getName());
            if (zipEntry.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                files.add(newFile);
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        return files;
    }

    public static boolean checkFileSize(MultipartFile file) {
        long fileSize = file.getSize();
        return fileSize >= 10240 && fileSize <= 3221225472L;
    }

    public static boolean checkFileType(MultipartFile file) {
        String fileType = file.getContentType();
        return fileType != null && fileType.equals("application/zip");
    }

    public static String getFileName(MultipartFile file) {
        return file.getOriginalFilename();
    }

    public static String getFileType(MultipartFile file) {
        return file.getContentType();
    }

    public static long getFileSize(MultipartFile file) {
        return file.getSize();
    }
}
