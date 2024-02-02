package com.example.tictactoetwoplayeronlinegame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginCredentialRequest {
    @JsonProperty("username")
    public String username;
    @JsonProperty("password")
    public String password;
}
