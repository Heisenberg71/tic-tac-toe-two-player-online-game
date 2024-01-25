package com.example.tictactoetwoplayeronlinegame.controller;

import com.example.tictactoetwoplayeronlinegame.dto.AccessToken;
import com.example.tictactoetwoplayeronlinegame.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    AccessToken login(@RequestParam String username, @RequestParam String password){
        AccessToken loginAccessToken = loginService.login(username, password);
        return loginAccessToken;
    }
}
