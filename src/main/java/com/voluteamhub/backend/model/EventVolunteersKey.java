package com.voluteamhub.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EventVolunteersKey implements Serializable {
    @Column(name = "event_id")
    Long eventId;

    @Column(name = "volunteer_id")
    Long volunteerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventVolunteersKey that = (EventVolunteersKey) o;
        return Objects.equals(eventId, that.eventId) && Objects.equals(volunteerId, that.volunteerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, volunteerId);
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long event) {
        this.eventId = event;
    }

    public long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(long student) {
        this.volunteerId = student;
    }
}
