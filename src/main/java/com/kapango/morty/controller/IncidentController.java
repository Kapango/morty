package com.kapango.morty.controller;

import com.kapango.morty.api.Incident;
import com.kapango.morty.api.IncidentApi;
import com.kapango.morty.service.IncidentNotFoundException;
import com.kapango.morty.service.IncidentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incident")
public class IncidentController implements IncidentApi {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/{id}")
    @Override
    public Incident getIncident(@PathVariable String id) throws IncidentNotFoundException {
        return incidentService.getIncident(id);
    }

    @PostMapping
    @Override
    public Incident createIncident(@RequestBody Incident request) {
        return incidentService.createIncident(request);
    }

    @PutMapping("/{id}")
    @Override
    public Incident updateIncident(@PathVariable String id, @RequestBody Incident request) {
        return incidentService.updateIncident(id, request);
    }

    @GetMapping("/severity/{severity}")
    @Override
    public List<Incident> getIncidentsBySeverity(@PathVariable String severity) {
        return incidentService.getIncidentsBySeverity(severity);
    }

    @GetMapping("/state/{state}")
    @Override
    public List<Incident> getIncidentsByState(@PathVariable String state) {
        return incidentService.getIncidentsByState(state);
    }
}
