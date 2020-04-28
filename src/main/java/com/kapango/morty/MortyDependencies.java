package com.kapango.morty;

import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.SlackClientFactory;
import com.hubspot.slack.client.SlackClientRuntimeConfig;
import com.kapango.morty.service.slack.SlackMessagingService;
import com.kapango.morty.config.SlackConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "Morty Dependencies")
public class MortyDependencies {

    private final SlackConfig slackConfig;

    @Autowired
    public MortyDependencies(SlackConfig slackConfig) {
        this.slackConfig = slackConfig;
    }

    @Bean
    @ConditionalOnProperty(name = "slack.enabled", havingValue = "true")
    public SlackMessagingService buildSlackService() {
        log.info("Building Slack Service");
        SlackClientRuntimeConfig runtimeConfig = SlackClientRuntimeConfig.builder()
                .setTokenSupplier(slackConfig::getApiKey)
                .build();

        SlackClient slackClient = SlackClientFactory.defaultFactory().build(runtimeConfig);

        return new SlackMessagingService(slackClient, slackConfig);
    }
}
