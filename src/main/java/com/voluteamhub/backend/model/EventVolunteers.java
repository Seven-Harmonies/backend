package com.voluteamhub.backend.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class EventVolunteers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
