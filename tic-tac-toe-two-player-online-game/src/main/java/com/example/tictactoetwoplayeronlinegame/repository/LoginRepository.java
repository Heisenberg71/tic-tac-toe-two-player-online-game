package com.example.tictactoetwoplayeronlinegame.repository;

import com.example.tictactoetwoplayeronlinegame.Model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Transactional
@Repository
public interface LoginRepository extends JpaRepository<Users, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET access_token = (?1) WHERE username = (?2) AND password = (?3)", nativeQuery = true)
    public void save(String access_token, String username, String password);

    @Query(value = "SELECT * FROM users WHERE username = (?1) AND password = (?2)", nativeQuery = true)
    public Collection<Users> userCredintialCheck(String username, String password);


}
