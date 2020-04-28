package com.kapango.morty.domain;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class IncidentSeverity {

    public static final String OUTAGE = "Outage";
    public static final String CRITICAL = "Critical";
    public static final String DISRUPTION = "Disruption";
    public static final String MINOR = "Minor";

    public static List<String> getSeverityLevels() {
        return ImmutableList.of(OUTAGE, CRITICAL, DISRUPTION, MINOR);
    }
}
