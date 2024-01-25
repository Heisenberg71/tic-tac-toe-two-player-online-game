package com.example.tictactoetwoplayeronlinegame.Model;

import com.example.tictactoetwoplayeronlinegame.dao.AccessToken;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private AccessToken accessToken;
}
