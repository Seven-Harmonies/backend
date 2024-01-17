/*package com.voluteamhub.backend.controller;

import com.voluteamhub.backend.model.Association;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {
    AssociationController associationController;
    VolunteerController volunteerController;
    @PostMapping("/loginEntity")
    public Optional logIn(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        Association newAssociation = getAssociationByCredentials(username, password);
        return associationRepository.findById(newAssociation.getId());}
}*/
