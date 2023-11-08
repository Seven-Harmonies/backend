package com.voluteamhub.backend.controller;

import com.voluteamhub.backend.model.Volunteer;
import com.voluteamhub.backend.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolunteerController {
    @Autowired
    private VolunteerRepository volunteerRepository;

    @PostMapping("/post")
    Volunteer newVolunteer(@RequestBody Volunteer newVolunteer) {
        return volunteerRepository.save(newVolunteer);
    }



}
