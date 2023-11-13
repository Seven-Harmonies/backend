package com.voluteamhub.backend.repository;

import com.voluteamhub.backend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
