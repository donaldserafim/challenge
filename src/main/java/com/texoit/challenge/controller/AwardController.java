package com.texoit.challenge.controller;

import com.texoit.challenge.dto.Award;
import com.texoit.challenge.service.AwardsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/award")
public class AwardController {

    @Autowired
    private AwardsManagerService awardsManager;

    @GetMapping("/winners")
    public Award getWinners(){
        return awardsManager.getWinners();
    }
}
