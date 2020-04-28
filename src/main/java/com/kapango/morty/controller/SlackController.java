package com.kapango.morty.controller;

import com.kapango.morty.service.slack.SlackMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Receives Slack slash commands as HTTP POST requests that are URL encoded
 *
 * https://api.slack.com/interactivity/slash-commands
 */
@RestController
public class SlackController {

    private static final String INCIDENT = "/incident";
    private static final String POSTMORTEM = "/postmortem";

    private final SlackMessagingService slackMessagingService;

    @Autowired
    public SlackController(SlackMessagingService slackMessagingService) {
        this.slackMessagingService = slackMessagingService;
    }

    @PostMapping(value = "/slack", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String incidentCommand(@RequestParam("token") String token,
                                  @RequestParam("team_id") String teamId,
                                  @RequestParam("team_domain") String teamDomain,
                                  @RequestParam("channel_id") String channelId,
                                  @RequestParam("channel_name") String channelName,
                                  @RequestParam("user_id") String userId,
                                  @RequestParam("user_name") String userName,
                                  @RequestParam("command") String command,
                                  @RequestParam("text") String text,
                                  @RequestParam("response_url") String responseUrl) {


        if (command.equals(INCIDENT)) {
            return "thanks mate";
        } else if (command.equals(POSTMORTEM)) {
            return "oi mate";
        } else {
            return "you wat mate?";
        }
    }
}