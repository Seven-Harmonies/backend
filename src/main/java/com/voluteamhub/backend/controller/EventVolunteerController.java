package com.voluteamhub.backend.controller;

import com.voluteamhub.backend.model.Event;
import com.voluteamhub.backend.model.EventVolunteers;
import com.voluteamhub.backend.model.Volunteer;
import com.voluteamhub.backend.repository.EventRepository;
import com.voluteamhub.backend.repository.EventVolunteersRepository;
import com.voluteamhub.backend.repository.VolunteerRepository;
import com.voluteamhub.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EventVolunteerController {

    @Autowired
    EventVolunteersRepository eventVolunteersRepository;
    VolunteerController volunteerController;
    EventService eventService;


    @PostMapping("/joinEvent")
    EventVolunteers newEventVolunteer(@RequestBody String eventName, String username){

        System.out.println("Event name: "+ eventName+ ", username: "+username);
        Volunteer volunteer = volunteerController.getVolunteerByUsername(username);
        Event event = eventService.getEventByName(eventName);

        if (volunteer != null && event != null) {
            EventVolunteers eventVolunteers = new EventVolunteers(event, volunteer);
            return eventVolunteersRepository.save(eventVolunteers);
        }
        return null;
    }
}
