package com.voluteamhub.backend.repository;

import com.voluteamhub.backend.model.Event;
import com.voluteamhub.backend.model.EventVolunteers;
import com.voluteamhub.backend.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventVolunteersRepository extends JpaRepository<EventVolunteers, Long> {
}
