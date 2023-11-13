package com.voluteamhub.backend.controller;

import com.voluteamhub.backend.model.Volunteer;
import com.voluteamhub.backend.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VolunteerController {
    private Map<String, Volunteer> loggedInVolunteers = new HashMap<>();
    @Autowired
    private VolunteerRepository volunteerRepository;

    public Volunteer getVolunteerByCredentials(String email, String password){
        List<Volunteer> listVolunteers = volunteerRepository.findAll();
        for (Volunteer v : listVolunteers)
            if (v.getEmail().equals(email) && v.getPassword().equals(password)) return v;
        return null;
    }

    @PostMapping("/postVolunteer")
    Volunteer newVolunteer(@RequestBody Volunteer newVolunteer) {
        return volunteerRepository.save(newVolunteer);
    }

    @GetMapping("/getvolunteer")
    List<Volunteer> getVolunteers() {
        return volunteerRepository.findAll();
    }

    @GetMapping("/loginVolunteer")
    public Volunteer logIn(String emailUsername, String password) {
        Volunteer newVolunteer = getVolunteerByCredentials(emailUsername, password);
        return volunteerRepository.getReferenceById(newVolunteer.getId());}

    @PostMapping("/registerVolunteer")
    public Volunteer registerVolunteer(String email, String lastName, String firstName, String phone, String userName, String photoUrl, String password) {
        Volunteer v = new Volunteer();
        v.setEmail(email);
        v.setLastName(lastName);
        v.setFirstName(firstName);
        v.setUserName(userName);
        v.setPhotoUrl(photoUrl);
        v.setPassword(password);
        v.setPhone(phone);
        return volunteerRepository.save(v);
    }


        /*List<Volunteer> listVolunteers = volunteerRepository.findAll();
        LoginValidator lv = new LoginValidator(emailUsername, password);
        String sessionId = String.valueOf(System.currentTimeMillis()); //Generate a random session ID
        //Nulitate
        if(lv.emptyUser(emailUsername, password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The Username/Email and Password fields can not be empty!");
        }
            else if (lv.emptyEmailUsername(emailUsername)){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The Username/Email field can not be empty!");
            }
                else if (lv.emptyPassword(password)){
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The Password field can not be empty!");
                }

        for (Volunteer v : listVolunteers) {
//username: admin si parola: admin sa mearga
            if (password.equals(v.getPassword()) && (emailUsername.equals(v.getUserName()) || emailUsername.equals(v.getEmail()))) {
                loggedInVolunteers.put(sessionId, v);
                return ResponseEntity.ok("Login successful!");
            } else if (!lv.validatePassword(password) && (emailUsername.equals(v.getUserName()) || emailUsername.equals(v.getEmail()))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password must be at least 8 characters " +
                        "long and contain at least one uppercase letter, one lowercase letter and one digit!");
            } else if (!password.equals(v.getPassword()) && (emailUsername.equals(v.getUserName()) || emailUsername.equals(v.getEmail()))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong password!");
            } else if (password.equals(v.getPassword()) && !lv.validateEmail(emailUsername) && !emailUsername.equals(v.getUserName())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email address must contain one or more characters " +
                        "(letters, digits and only _-. symbols), one @ symbol, after that more characters, a dot and at least " +
                        "2 letters.!");
            } else if (password.equals(v.getPassword()) && !emailUsername.equals(v.getUserName()) && !emailUsername.equals(v.getEmail())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong email/username!");
            }
        }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("This user doesn't exist!");
    }*/


    @GetMapping("/logoutVolunteer")
    public ResponseEntity<String> logout(String sessionId) {
        if (loggedInVolunteers.containsKey(sessionId)){
            loggedInVolunteers.remove(sessionId);
            return ResponseEntity.ok("Logout successful!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("This user is not logged in!");
    }
}
