package com.kapango.morty.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Incident {

    private String id;
    @NotNull
    private String description;
    @NotEmpty
    private List<String> systems;
    @NotNull
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @NotNull
    private String severity;
    private boolean recurringIncident;
    private String linkedIncidentId;
    private String state;
}
