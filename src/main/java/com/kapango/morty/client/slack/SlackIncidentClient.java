package com.kapango.morty.client.slack;

import com.kapango.morty.api.Incident;
import com.kapango.morty.api.IncidentApi;
import com.kapango.morty.service.IncidentNotFoundException;

import java.util.List;

public class SlackIncidentClient implements IncidentApi {

    @Override
    public Incident getIncident(String id) throws IncidentNotFoundException {
        return null;
    }

    @Override
    public Incident createIncident(Incident request) {
        return null;
    }

    @Override
    public Incident updateIncident(String id, Incident request) {
        return null;
    }

    @Override
    public List<Incident> getIncidentsBySeverity(String severity) {
        return null;
    }

    @Override
    public List<Incident> getIncidentsByState(String state) {
        return null;
    }
}
