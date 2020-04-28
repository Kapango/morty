package com.kapango.morty.service.incident;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No incident found")
public class IncidentNotFoundException extends Exception {

    public IncidentNotFoundException() {
    }

    public IncidentNotFoundException(String message) {
        super(message);
    }

    public IncidentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
