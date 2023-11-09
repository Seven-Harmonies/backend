package com.voluteamhub.backend.controller;

import com.voluteamhub.backend.model.Volunteer;
import com.voluteamhub.backend.repository.VolunteerRepository;
import com.voluteamhub.backend.validator.LoginValidator;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VolunteerController {
    @Autowired
    private VolunteerRepository volunteerRepository;

    @PostMapping("/post")
    Volunteer newVolunteer(@RequestBody Volunteer newVolunteer) {
        return volunteerRepository.save(newVolunteer);
    }

    @GetMapping("/getvolunteer")
    List<Volunteer> getVolunteers(){
        return volunteerRepository.findAll();
    }

    @GetMapping("/login")
    void loginUser(Volunteer v){
        LoginIn(v);
    }


    public void LoginIn(Volunteer v){
        List<Volunteer> listaVoluntari = volunteerRepository.findAll();


        for(Volunteer volunteer: listaVoluntari){
            LoginValidator lv = new LoginValidator(volunteer);

        }
    }
}
