package com.aiassistant.service;

import com.aiassistant.model.LotteryEntry;
import com.aiassistant.utils.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LotteryService {
    ResultModel<List<LotteryEntry>> drawLottery(int winnerCount, MultipartFile file);
}
