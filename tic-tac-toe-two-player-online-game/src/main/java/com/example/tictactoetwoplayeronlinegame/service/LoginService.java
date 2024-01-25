package com.example.tictactoetwoplayeronlinegame.service;

import com.example.tictactoetwoplayeronlinegame.Model.User;
import com.example.tictactoetwoplayeronlinegame.dao.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;
    AccessToken login(String username, String password){
        AccessToken accessToken = generateAccessToken(username, password);

        User user = User.builder()
                .username(username)
                .password(password)
                .accessToken(accessToken)
                .build();

        loginRepoImpl.save(user);

        return accessToken;
    }

    private AccessToken generateAccessToken(String username, String password){
        String accessTokenStr = username + password;
        AccessToken accessToken = AccessToken.builder()
                .accessToken(accessTokenStr)
                .build();

        return accessToken;
    }
}
