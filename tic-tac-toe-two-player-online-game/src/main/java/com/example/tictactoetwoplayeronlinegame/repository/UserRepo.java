package com.example.tictactoetwoplayeronlinegame.repository;

import com.example.tictactoetwoplayeronlinegame.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepo extends JpaRepository<User, Integer> {
    void save(User user){

    }
}
