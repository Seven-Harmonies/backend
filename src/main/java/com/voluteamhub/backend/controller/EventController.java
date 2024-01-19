package com.voluteamhub.backend.controller;

import com.voluteamhub.backend.model.Event;
import com.voluteamhub.backend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/getEvents")
    public List<Event> getAllEvents(){
        System.out.println("salut...ce faci...ma auziiii?");
        return eventRepository.findAll();
    }

}
