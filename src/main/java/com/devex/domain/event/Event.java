package com.devex.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Event {

    private final String id;
    private final LocalDateTime timestamp;

    public Event() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
