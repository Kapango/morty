package com.kapango.morty.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class SlackController {

    @PostMapping(value = "/slack/incident", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
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

        return "yolo";
    }

    @PostMapping(value = "/slack/postmortem", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postMortemCommand(@RequestParam("token") String token,
                                    @RequestParam("team_id") String teamId,
                                    @RequestParam("team_domain") String teamDomain,
                                    @RequestParam("channel_id") String channelId,
                                    @RequestParam("channel_name") String channelName,
                                    @RequestParam("user_id") String userId,
                                    @RequestParam("user_name") String userName,
                                    @RequestParam("command") String command,
                                    @RequestParam("text") String text,
                                    @RequestParam("response_url") String responseUrl) {

        return "postmortem";
    }
}