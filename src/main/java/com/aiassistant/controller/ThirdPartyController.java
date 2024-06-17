package com.aiassistant.controller;

import com.aiassistant.service.ThirdPartyService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/third-party")
public class ThirdPartyController {

    private final ThirdPartyService thirdPartyService;

    @Autowired
    public ThirdPartyController(ThirdPartyService thirdPartyService) {
        this.thirdPartyService = thirdPartyService;
    }

    @PostMapping("/access")
    public ResultModel<String> accessThirdParty(@RequestParam String platform, @RequestParam String userId, @RequestParam String orderInfo) {
        return thirdPartyService.accessThirdParty(platform, userId, orderInfo);
    }
}
