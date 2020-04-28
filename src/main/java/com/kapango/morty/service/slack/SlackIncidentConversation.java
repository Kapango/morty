package com.kapango.morty.service.slack;

import com.kapango.morty.api.Incident;

public class SlackIncidentConversation extends Incident {

    private String conversationState;


    public class ConversationState {
        public static final String STARTED = "Started";
        public static final String NAME = "Name";
        public static final String DESCRIPTION = "Description";
        public static final String REPORTED_TIME = "Reported_Time";
        public static final String FINISHED = "Finished";
    }
}
