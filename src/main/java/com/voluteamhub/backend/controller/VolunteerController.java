package com.voluteamhub.backend.controller;

import com.voluteamhub.backend.model.Volunteer;
import com.voluteamhub.backend.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VolunteerController {
    private Map<String, Volunteer> loggedInVolunteers = new HashMap<>();
    @Autowired
    private VolunteerRepository volunteerRepository;

    public Volunteer getVolunteerByCredentials(String username, String password){
        System.out.println("Inainte de findAll");
        List<Volunteer> listVolunteers = volunteerRepository.findAll();
        System.out.println("Dupa find all");
        System.out.println(listVolunteers.get(0).getId());
        for (Volunteer v : listVolunteers){
            System.out.println("username param: " + username + " username v: " + v.getUser_name());
            System.out.println("password param: " + password + " password v: " + v.getPassword());

            if (v.getUser_name().equals(username) && v.getPassword().equals(password)){
                System.out.println(v);
                return v;
            }
        }

        return null;
    }

    @PostMapping("/postVolunteer")
    Volunteer newVolunteer(@RequestBody Volunteer newVolunteer) {
        return volunteerRepository.save(newVolunteer);
    }

    @GetMapping("/getVolunteer")
    List<Volunteer> getVolunteers() {
        return volunteerRepository.findAll();
    }

    @GetMapping("/loginHandleVolunteer")
    public boolean loginHandleVolunteer(@RequestBody Map<String, String> credentials){
        String username = credentials.get("username");
        String password = credentials.get("password");
        if (getVolunteerByCredentials(username, password) != null)
            return true;
        return false;
    }

    @PostMapping("/loginVolunteer")
    public Optional<Volunteer> logIn(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        Volunteer newVolunteer = getVolunteerByCredentials(username, password);
        return volunteerRepository.findById(newVolunteer.getId());}

    @PostMapping("/registerVolunteer")
    public Optional<Volunteer> registerVolunteer(@RequestBody Map<String,String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        String email = credentials.get("email");
        String firstname = credentials.get("firstname");
        String lastname = credentials.get("lastname");
        String phone = credentials.get("phone");
        String photourl = credentials.get("photourl");
        Volunteer newVolunteer = new Volunteer(email,lastname,firstname,phone,username,photourl,password);
        return Optional.of(volunteerRepository.save(newVolunteer));
    }

    /*public Optional<Volunteer> registerVolunteer(@RequestBody Map<String,String> credentials){
        String username = credentials.get("username");
        String password = credentials.get("password");
        String email = credentials.get("email");
        String firstname = credentials.get("firstname");
        String lastname = credentials.get("lastname");
        String phone = credentials.get("phone");
        String photourl = credentials.get("photourl");
        Volunteer newVolunteer = new Volunteer(email,lastname,firstname,phone,username,photourl,password);
        return Optional.of(volunteerRepository.save(newVolunteer));
    }*/

    @GetMapping("/logout")
    public ResponseEntity<String> logout(String sessionId) {
        if (loggedInVolunteers.containsKey(sessionId)){
            loggedInVolunteers.remove(sessionId);
            return ResponseEntity.ok("Logout successful!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("This user is not logged in!");
    }
}
