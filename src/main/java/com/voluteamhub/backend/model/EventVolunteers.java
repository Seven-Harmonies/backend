package com.voluteamhub.backend.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class EventVolunteers {
    @Id
    @GeneratedValue
    EventVolunteersKey id;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    Event event;

    @ManyToOne
    @MapsId("volunteerId")
    @JoinColumn(name = "volunteer_id")
    Volunteer volunteer;

    public EventVolunteers(Event event, Volunteer volunteer) {
        this.event = event;
        this.volunteer = volunteer;
    }

    public EventVolunteers() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventVolunteers that = (EventVolunteers) o;
        return Objects.equals(id, that.id) && Objects.equals(event, that.event) && Objects.equals(volunteer, that.volunteer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event, volunteer);
    }

    public EventVolunteersKey getId() {
        return id;
    }

    public void setId(EventVolunteersKey id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

}
