package com.voluteamhub.backend.controller;

import com.voluteamhub.backend.model.Association;
import com.voluteamhub.backend.model.Volunteer;
import com.voluteamhub.backend.repository.AssociationRepository;
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
public class AssociationController {
    @Autowired
    private AssociationRepository associationRepository;

    @PostMapping("/post")
    Association newAssociation (@RequestBody Association newAssociation) {
        return associationRepository.save(newAssociation);
    }

    @GetMapping("/getassociation")
    List<Association> getAssociations() {
        return associationRepository.findAll();
    }


    public Association getAssociationByCredentials(String email, String password){
        List<Association> listAssociation = associationRepository.findAll();
        for (Association v : listAssociation)
            if (v.getEmail().equals(email) && v.getPassword().equals(password)) return v;
        return null;
    }

    @PostMapping("/register")
    public Association registerAssociation(String email, String phone, String photoUrl, String userName, String password, String name){
        Association v = new Association();
        v.setEmail(email);
        v.setUserName(userName);
        v.setPhotoUrl(photoUrl);
        v.setPassword(password);
        v.setPhone(phone);
        return associationRepository.save(v);
    }

    @GetMapping("/login")
    public Association logIn(String emailUsername, String password) {
        Association newAssociation = getAssociationByCredentials(emailUsername, password);
        return associationRepository.getReferenceById(newAssociation.getId());}


        /*List<Association> listAssociations = associationRepository.findAll();
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

        for (Association a : listAssociations) {
            if (password.equals(a.getPassword()) && (emailUsername.equals(a.getUserName()) || emailUsername.equals(a.getEmail()))) {
                loggedInAssociations.put(sessionId, a);
                return ResponseEntity.ok("Login successful!");
            } else if (!lv.validatePassword(password) && (emailUsername.equals(a.getUserName()) || emailUsername.equals(a.getEmail()))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password must be at least 8 characters " +
                        "long and contain at least one uppercase letter, one lowercase letter and one digit!");
            } else if (!password.equals(a.getPassword()) && (emailUsername.equals(a.getUserName()) || emailUsername.equals(a.getEmail()))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong password!");
            } else if (password.equals(a.getPassword()) && !lv.validateEmail(emailUsername) && !emailUsername.equals(a.getUserName())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email address must contain one or more characters " +
                        "(letters, digits and only _-. symbols), one @ symbol, after that more characters, a dot and at least " +
                        "2 letters.!");
            } else if (password.equals(a.getPassword()) && !emailUsername.equals(a.getUserName()) && !emailUsername.equals(a.getEmail())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong email/username!");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("This user doesn't exist!");*/

}


