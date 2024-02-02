package com.example.tictactoetwoplayeronlinegame.config;

import org.springframework.stereotype.Component;
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }

}
