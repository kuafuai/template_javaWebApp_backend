package com.aiassistant.service.impl;

import com.aiassistant.model.LotteryEntry;
import com.aiassistant.service.LotteryService;
import com.aiassistant.utils.ResultModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Override
    public ResultModel<List<LotteryEntry>> drawLottery(int winnerCount, MultipartFile file) {
        if (winnerCount <= 0) {
            return new ResultModel<>(false, "中奖人数必须大于零", null);
        }

        List<LotteryEntry> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    String employeeId = parts[1].trim();
                    entries.add(new LotteryEntry(name, employeeId));
                }
            }
        } catch (Exception e) {
            return new ResultModel<>(false, "文件读取出错：" + e.getMessage(), null);
        }

        if (entries.size() < winnerCount) {
            return new ResultModel<>(false, "参与抽奖人数不足", null);
        }

        Set<LotteryEntry> winners = new HashSet<>();
        Random random = new Random();
        while (winners.size() < winnerCount) {
            int randomIndex = random.nextInt(entries.size());
            winners.add(entries.get(randomIndex));
        }

        return new ResultModel<>(true, "抽奖成功", new ArrayList<>(winners));
    }
}
