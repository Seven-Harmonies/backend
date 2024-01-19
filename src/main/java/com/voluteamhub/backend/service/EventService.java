package com.voluteamhub.backend.service;

import com.voluteamhub.backend.model.Event;
import com.voluteamhub.backend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {


    @Autowired
    EventRepository eventRepository;


    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventByName(String name){
        List<Event> allEvents = getAllEvents();
        for (Event e : allEvents)
            if (e.getName().equals(name)) return e;

        return null;
    }

}
