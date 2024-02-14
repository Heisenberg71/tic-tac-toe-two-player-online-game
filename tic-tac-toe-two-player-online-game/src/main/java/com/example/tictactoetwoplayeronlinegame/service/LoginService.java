package com.example.tictactoetwoplayeronlinegame.service;

import com.example.tictactoetwoplayeronlinegame.Model.Users;
import com.example.tictactoetwoplayeronlinegame.config.UnauthorizedException;
import com.example.tictactoetwoplayeronlinegame.repository.InvitationRepository;
import com.example.tictactoetwoplayeronlinegame.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    final static Logger logger = LoggerFactory.getLogger(InvitationService.class);
    UnauthorizedException unauthorizedException;

    @Autowired
    LoginRepository loginRepository;

    public String login(String username, String password){
        String accessToken = username + password;

        Users users = Users.builder()
                .username(username)
                .password(password)
                .accessToken(accessToken)
                .build();

        if(loginRepository.userCredintialCheck(username, password).size() == 0){
            logger.info("Unauthorized Access");
            throw new UnauthorizedException("You are not authorized");
        }

        loginRepository.save(accessToken, username, password);

        logger.info("Access Granted");
        return accessToken;
    }
}
