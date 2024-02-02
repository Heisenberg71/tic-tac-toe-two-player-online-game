package com.example.tictactoetwoplayeronlinegame.controller;

import com.example.tictactoetwoplayeronlinegame.dto.Request;
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
    String login(@RequestBody Request request) throws JsonProcessingException {
        String username = request.username;
        String password = request.password;
        String loginAccessToken = loginService.login(username, password);

        Map<String, String> object = new HashMap<>();
        object.put("access_token", loginAccessToken);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
