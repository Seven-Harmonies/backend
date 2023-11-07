package com.voluteamhub.backend.repository;

import com.voluteamhub.backend.model.Volunteer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VolunteerRepoTest {
    private VolunteerRepo sv;
    private DataSourceProperties db;
    @BeforeEach
    void setUp(){
        db = new DataSourceProperties(
                "seven-harmonies.ccll3k2ugiuj.us-east-1.rds.amazonaws.com",
                5432,
                "volunteamhub",
                "postgres",
                "7harmonies"
        );
        sv = new VolunteerRepo(db);
    }

    @Test
    void shouldListAllVolunteers() {
        List<Volunteer> volunteers = sv.handleRequest();
        assertEquals(1, volunteers.size());
    }
}