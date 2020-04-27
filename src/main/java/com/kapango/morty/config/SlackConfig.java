package com.kapango.morty.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class SlackConfig {

    @Value("${slack.enabled}")
    private boolean slackEnabled;

    @Value("${slack.apiKey}")
    private String apiKey;

    @Value("${slack.channel}")
    private String channel = "general";
}
