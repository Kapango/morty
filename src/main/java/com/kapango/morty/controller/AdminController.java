package com.kapango.morty.controller;

import com.kapango.morty.service.slack.SlackMessagingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final SlackMessagingService slackMessagingService;

    public AdminController(SlackMessagingService slackMessagingService) {
        this.slackMessagingService = slackMessagingService;
    }

    @GetMapping("/slack/ping")
    public void pingSlack() {
        slackMessagingService.ping();
    }


}
