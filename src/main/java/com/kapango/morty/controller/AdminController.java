package com.kapango.morty.controller;

import com.kapango.morty.client.slack.SlackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final SlackService slackService;

    public AdminController(SlackService slackService) {
        this.slackService = slackService;
    }

    @GetMapping("/slack/ping")
    public void pingSlack() {
        slackService.ping();
    }


}
