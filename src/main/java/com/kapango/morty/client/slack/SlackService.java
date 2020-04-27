package com.kapango.morty.client.slack;

import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.methods.params.chat.ChatPostMessageParams;
import com.hubspot.slack.client.methods.params.conversations.ConversationsJoinParams;
import com.kapango.morty.config.SlackConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "Slack Service")
public class SlackService {

    private final SlackClient slackClient;
    private final String channel;

    public SlackService(SlackClient slackClient, SlackConfig config) {
        log.info("Starting the service");
        this.slackClient = slackClient;
        this.channel = config.getChannel();

        try {
            joinChannel();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void joinChannel() {
        log.info("Connecting to channel {}", channel);

        slackClient.joinConversation(ConversationsJoinParams.builder()
                .setChannelId(channel)
                .build())
                .join()
                .unwrapErrOrElseThrow();
    }

    public void ping() {
        log.info("Pinging channel {}", channel);

        slackClient.postMessage(ChatPostMessageParams.builder()
                .setText("Ping!")
                .setChannelId(channel)
                .setUsername("morty")
                .build())
                .join()
                .unwrapErrOrElseThrow();
    }
}
