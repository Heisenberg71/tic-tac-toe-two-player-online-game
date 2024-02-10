package com.example.tictactoetwoplayeronlinegame.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InvitationController {
    @Autowired
    InvitationService invitationService;

    @GetMapping("/invitations")
    String getInvitations(@RequestParam String username) throws JsonProcessingException {
        List<String> invitations =  invitationService.getInvitation(username);

        Gson gson = new Gson();
        String invitationsJsonArray = gson.toJson(invitations);

        Map<String, String> object = new HashMap<>();
        object.put("invitations", invitationsJsonArray);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @PostMapping("/invitation")
    String sendInvitation(@RequestBody String username) throws JsonProcessingException {
        String sendInvitationResponse = invitationService.sendInvitation(username);

        Map<String, String> object = new HashMap<>();
        object.put("sending_status", sendInvitationResponse);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @PostMapping("/accept")
    String acceptInvitation(@RequestBody String username) throws JsonProcessingException {
        String acceptInvitationService = invitationService.acceptInvitation(username);

        Map<String, String> object = new HashMap<>();
        object.put("accept", acceptInvitationService);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @PostMapping("/reject")
    String rejectInvitation(@RequestBody String username) throws JsonProcessingException {
        String rejectInvitationService = invitationService.rejectInvitation(username);

        Map<String, String> object = new HashMap<>();
        object.put("reject", rejectInvitationService);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}

