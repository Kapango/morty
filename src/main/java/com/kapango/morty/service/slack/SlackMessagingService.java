package com.kapango.morty.service.slack;

import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.methods.params.chat.ChatPostMessageParams;
import com.hubspot.slack.client.methods.params.conversations.ConversationsJoinParams;
import com.kapango.morty.config.SlackConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "Slack Messaging Service")
public class SlackMessagingService {

    private final SlackClient slackClient;
    private final String channel;
    private final String username;

    public SlackMessagingService(SlackClient slackClient, SlackConfig config) {
        log.info("Starting the service");
        this.slackClient = slackClient;
        this.channel = config.getChannel();
        this.username = config.getUsername();
        joinSlackChannel();
    }

    public void joinSlackChannel() {
        try {
            log.info("Joining slack channel {}", channel);
            slackClient.joinConversation(ConversationsJoinParams.builder()
                    .setChannelId(channel)
                    .build())
                    .join()
                    .unwrapErrOrElseThrow();
        } catch (Exception e) {
            log.info("Already joined channel {}", channel);
        }
    }

    public void sendMessage(ChatPostMessageParams messageParams) {
        log.info("Sending slack message : {}", messageParams.getText());
        slackClient.postMessage(messageParams)
                .join()
                .unwrapErrOrElseThrow();
    }

    public void ping() {
        log.info("Sending ping to slack channel : {}", channel);
        sendMessage(ChatPostMessageParams.builder()
                .setText("Ping!")
                .setChannelId(channel)
                .setUsername(username)
                .build());
    }
}
