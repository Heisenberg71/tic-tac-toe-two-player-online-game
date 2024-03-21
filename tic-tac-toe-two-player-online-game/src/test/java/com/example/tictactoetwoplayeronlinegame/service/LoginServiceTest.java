package com.example.tictactoetwoplayeronlinegame.service;

import com.example.tictactoetwoplayeronlinegame.Model.Users;
import com.example.tictactoetwoplayeronlinegame.repository.LoginRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @InjectMocks
    LoginService loginService;

    @Mock
    LoginRepository loginRepository;

    @Test
    void login() {
        var users = Users.builder()
                .username("samin")
                .password("1234")
                .accessToken("samin1234").build();

        Collection<Users> allUsers = new ArrayList<>();
        allUsers.add(users);

        when(loginRepository.userCredintialCheck(any(), any())).thenReturn(allUsers);
        //verify(loginRepository, times(1)).save(any(), any(), any());
        String actual = loginService.login("samin", "1234");
        assertEquals("samin1234", actual);
    }
}