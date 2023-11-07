package com.voluteamhub.backend.repository;

import com.voluteamhub.backend.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;

public interface associationRepo extends JpaRepository<Association,Long> {
}