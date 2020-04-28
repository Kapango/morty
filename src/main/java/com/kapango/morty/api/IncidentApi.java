package com.kapango.morty.api;

import com.kapango.morty.service.incident.IncidentNotFoundException;

import java.util.List;

public interface IncidentApi {

    Incident getIncident(String id) throws IncidentNotFoundException;

    Incident createIncident(Incident request);

    Incident updateIncident(String id, Incident request);

    List<Incident> getIncidentsBySeverity(String severity);

    List<Incident> getIncidentsByState(String state);
}
