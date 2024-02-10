package com.example.tictactoetwoplayeronlinegame.controller;

import com.example.tictactoetwoplayeronlinegame.dto.LoginCredentialRequest;
import com.example.tictactoetwoplayeronlinegame.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@ResponseBody
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    String login(@RequestBody LoginCredentialRequest loginCredentialRequest) throws JsonProcessingException {
        String username = loginCredentialRequest.username;
        String password = loginCredentialRequest.password;
        String loginAccessToken = loginService.login(username, password);

        Map<String, String> object = new HashMap<>();
        object.put("access_token", loginAccessToken);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
