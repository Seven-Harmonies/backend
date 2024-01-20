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

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EventVolunteerController {

    @Autowired
    EventVolunteersRepository eventVolunteersRepository;
    @Autowired
    VolunteerController volunteerController;
    @Autowired
    EventService eventService;


    @PostMapping("/joinEvent")
    EventVolunteers newEventVolunteer(@RequestBody Map<String, String> requestBody) {
        String eventName = requestBody.get("eventName");
        String username = requestBody.get("username");

        if (eventName == null || username == null) {
            // Tratează cazul în care eventName sau username sunt null
            System.out.println("eventName sau username sunt null");
            return null;
        }

        Volunteer volunteer = volunteerController.getVolunteerByUsername(username);
        Event event = eventService.getEventByName(eventName);

        if (volunteer == null || event == null) {
            // Tratează cazul în care volunteer sau event sunt null
            System.out.println("volunteer sau event sunt null");
            return null;
        }

        // Verifică dacă există deja o înregistrare pentru același voluntar și același eveniment
        List<EventVolunteers> existingEntries = eventVolunteersRepository.findAll();
        for (EventVolunteers existingEntry : existingEntries) {
            if (existingEntry.getVolunteer().getId() == volunteer.getId() && existingEntry.getEvent().getId()==event.getId()) {
                // Tratează cazul în care există deja o înregistrare
                System.out.println("Voluntarul a participat deja la acest eveniment");
                return null;
            }
        }

        // Creează direct instanța EventVolunteers folosind constructorul adăugat
        EventVolunteers eventVolunteer = new EventVolunteers(event, volunteer);

        return eventVolunteersRepository.save(eventVolunteer);
    }

}
