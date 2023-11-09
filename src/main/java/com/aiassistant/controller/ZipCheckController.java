package com.aiassistant.controller;

import com.aiassistant.mapper.AlmTalbleMapper;
import com.aiassistant.model.AlmModel;
import com.aiassistant.utils.ResultModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
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

    Pattern itero_pattern = Pattern.compile("itero_export_#\\d+_v50\\.xml");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @Autowired
    private AlmTalbleMapper almTalbleMapper;

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

            StringBuilder iteroContent = new StringBuilder();

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
                } else if (itero_pattern.matcher(fileName).matches()) {
                    InputStream inputStream = zipFile.getInputStream(entry);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        iteroContent.append(line);
                    }

                    // 关闭输入流
                    reader.close();
                    inputStream.close();
                } else {
                    System.err.println("file - " + entry.getName() + " : " + entry.getSize() + " bytes");
                }
            }

            zipFile.close();
            tempFile.delete();

            List<String> result = new ArrayList<>();

            if (shell_l && shell_u) {
                result.add("模型文件符合要求");
            } else if (lprofile_l && lprofile_u) {
                result.add("模型文件包含底座，不符合要求");
            } else if (lockedocclusion) {
                result.add("模型文件只包含咬合文件，不符合要求");
            } else {
                result.add("没有找到合法文件");
                return ResultModel.ofSuccess(result);
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(iteroContent.toString()));
            Document doc = dBuilder.parse(inputSource);
            String uniqueValue = doc.getElementsByTagName("UniquePatientIdentifier").item(0).getTextContent();
            String dueDateValue = doc.getElementsByTagName("DueDate").item(0).getTextContent();
            String exportTimeValue = doc.getElementsByTagName("ExportTime").item(0).getTextContent();

            AlmModel oldModel = almTalbleMapper.getByUniqueKey(uniqueValue);
            if (oldModel != null) {
                result.add("模型文件不唯一，可能不是同一个人的数据");
            } else {
                AlmModel newModel = new AlmModel();
                newModel.setUniqueKey(uniqueValue);
                newModel.setDueDate(dueDateValue);
                newModel.setExportTime(exportTimeValue);
                almTalbleMapper.insert(newModel);
            }

            LocalDate dueDate = LocalDate.parse(dueDateValue, formatter);
            LocalDate currentDate = LocalDate.now();
            Period period = dueDate.until(currentDate);
            int year = period.getYears();
            int month = period.getMonths();
            int daysDifference = period.getDays();

            if (year > 0 || month > 0 || daysDifference > 14) {
                result.add("模型数据采集时间过长");
            }
            return ResultModel.ofSuccess(result);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.ofError(e.getMessage());
        }
    }
}
