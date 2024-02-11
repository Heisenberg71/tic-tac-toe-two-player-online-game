package com.example.tictactoetwoplayeronlinegame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvitationRequest {
    @JsonProperty("sender")
    public String sender;
    @JsonProperty("receiver")
    public String receiver;
}
