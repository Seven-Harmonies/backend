package com.voluteamhub.backend.repository;

import com.voluteamhub.backend.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface volunteerRepository extends JpaRepository<Volunteer, Long> {

}
