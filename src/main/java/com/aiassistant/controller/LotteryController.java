package com.aiassistant.controller;

import com.aiassistant.model.LotteryEntry;
import com.aiassistant.service.LotteryService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    private final LotteryService lotteryService;

    @Autowired
    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @PostMapping("/draw")
    public ResultModel<List<LotteryEntry>> drawLottery(@RequestParam int winnerCount, @RequestParam MultipartFile file) {
        return lotteryService.drawLottery(winnerCount, file);
    }
}
