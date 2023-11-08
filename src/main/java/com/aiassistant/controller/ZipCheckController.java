package com.aiassistant.controller;

import com.aiassistant.utils.ResultModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


@RestController
@RequestMapping("/zip")
public class ZipCheckController {

    Pattern shell_pattern_l = Pattern.compile("\\d+_shell_occlusion_l\\.stl");
    Pattern shell_pattern_u = Pattern.compile("\\d+_shell_occlusion_u\\.stl");

    Pattern lprofile_pattern_l = Pattern.compile("\\d+_lprofile_occlusion_l\\.ply");
    Pattern lprofile_pattern_u = Pattern.compile("\\d+_lprofile_occlusion_u\\.ply");

    Pattern lockedocclusion_pattern = Pattern.compile("\\d+_shell_lockedocclusion_ul\\.ply");

    @PostMapping("/check")
    public ResultModel uploadFile(@RequestParam("file") MultipartFile file) {
        try {

            File tempFile = File.createTempFile("temp", ".zip");
            file.transferTo(tempFile);

            boolean shell_l = false;
            boolean shell_u = false;
            boolean lprofile_l = false;
            boolean lprofile_u = false;

            boolean lockedocclusion = false;

            ZipFile zipFile = new ZipFile(tempFile);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String fileName = entry.getName();

                if (shell_pattern_l.matcher(fileName).matches()) {
                    shell_l = true;
                    System.out.println("shell_l " + fileName);
                } else if (shell_pattern_u.matcher(fileName).matches()) {
                    shell_u = true;
                    System.out.println("shell_u " + fileName);
                } else if (lprofile_pattern_l.matcher(fileName).matches()) {
                    lprofile_l = true;
                    System.out.println("lprofile_l " + fileName);
                } else if (lprofile_pattern_u.matcher(fileName).matches()) {
                    lprofile_u = true;
                    System.out.println("lprofile_u " + fileName);
                } else if (lockedocclusion_pattern.matcher(fileName).matches()) {
                    lockedocclusion = true;
                    System.out.println("lockedocclusion " + fileName);
                } else {
                    System.err.println("file - " + entry.getName() + " : " + entry.getSize() + " bytes");
                }
            }

            zipFile.close();
            tempFile.delete();

            if (shell_l && shell_u) {
                return ResultModel.ofSuccess("模型文件符合要求", "");
            } else if (lprofile_l && lprofile_u) {
                return ResultModel.ofError("模型文件包含底座，不符合要求");
            } else if (lockedocclusion) {
                return ResultModel.ofError("模型文件只包含咬合文件，不符合要求");
            } else {
                return ResultModel.ofError("没有找到合法文件");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.ofError(e.getMessage());
        }
    }
}
