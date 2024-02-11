package com.example.tictactoetwoplayeronlinegame.controller;

import com.example.tictactoetwoplayeronlinegame.dto.InvitationRequest;
import com.example.tictactoetwoplayeronlinegame.service.InvitationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.antlr.v4.runtime.misc.NotNull;
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
    String getInvitations(@RequestParam @NotNull String username) throws JsonProcessingException {
        List<String> invitations =  invitationService.getInvitation(username);

        Gson gson = new Gson();
        String invitationsJsonArray = gson.toJson(invitations);

        Map<String, String> object = new HashMap<>();
        object.put("invitations", invitationsJsonArray);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @PostMapping("/invitation")
    String sendInvitation(@RequestBody @NotNull InvitationRequest invitationRequest) throws JsonProcessingException {
        String sendInvitationResponse = invitationService.sendInvitation(invitationRequest);

        Map<String, String> object = new HashMap<>();
        object.put("sending_status", sendInvitationResponse);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @PostMapping("/accept")
    String acceptInvitation(@RequestBody @NotNull InvitationRequest invitationRequest) throws JsonProcessingException {
        String acceptInvitationService = invitationService.acceptInvitation(invitationRequest);

        Map<String, String> object = new HashMap<>();
        object.put("accept", acceptInvitationService);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @PostMapping("/reject")
    String rejectInvitation(@RequestBody @NotNull InvitationRequest invitationRequest) throws JsonProcessingException {
        String rejectInvitationService = invitationService.rejectInvitation(invitationRequest);

        Map<String, String> object = new HashMap<>();
        object.put("reject", rejectInvitationService);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}

