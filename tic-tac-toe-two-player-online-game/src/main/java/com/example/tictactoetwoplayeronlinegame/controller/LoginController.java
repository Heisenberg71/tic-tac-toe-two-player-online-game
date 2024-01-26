package com.example.tictactoetwoplayeronlinegame.controller;

import com.example.tictactoetwoplayeronlinegame.dao.AccessToken;
import com.example.tictactoetwoplayeronlinegame.dto.LoginCredentialRequest;
import com.example.tictactoetwoplayeronlinegame.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public AccessToken login(@RequestBody LoginCredentialRequest loginCredential){
        AccessToken loginAccessToken = loginService.login(loginCredential.username, loginCredential.password);
        return loginAccessToken;
    }
}
