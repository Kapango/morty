package com.kapango.morty.service;

import com.kapango.morty.api.Incident;
import com.kapango.morty.api.IncidentApi;
import com.kapango.morty.repo.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentService implements IncidentApi {

    private final IncidentRepository repository;

    @Autowired
    public IncidentService(IncidentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Incident getIncident(String id) throws IncidentNotFoundException {
        Optional<Incident> incident = repository.findById(id);

        if (incident.isEmpty()) {
            throw new IncidentNotFoundException("Could not find incident with id : " + id);
        }
        return incident.get();
    }

    @Override
    public Incident createIncident(Incident request) {
        return repository.save(request);
    }

    @Override
    public Incident updateIncident(String id, Incident request) {
        return repository.save(request);
    }

    @Override
    public List<Incident> getIncidentsBySeverity(String severity) {
        return repository.findAllBySeverity(severity);
    }

    @Override
    public List<Incident> getIncidentsByState(String state) {
        return repository.findAllByState(state);
    }
}
