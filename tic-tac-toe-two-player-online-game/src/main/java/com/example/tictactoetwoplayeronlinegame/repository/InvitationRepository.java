package com.example.tictactoetwoplayeronlinegame.repository;

import com.example.tictactoetwoplayeronlinegame.Model.Invitation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.yaml.snakeyaml.tokens.Token.ID.Value;

@Transactional
@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    @Query(value = "SELECT sender FROM invitation WHERE receiver = (:receiver)", nativeQuery = true)
    public List<String> getInvitation(@Param("receiver") String receiver);

    @Modifying
    @Query(value = "INSERT INTO invitation (receiver, sender) VALUES (:receiver, :sender)", nativeQuery = true)
    void sendInvitation(@Param("receiver") String receiver, @Param("sender") String sender);

    @Modifying
    @Query(value = "DELETE FROM invitation WHERE receiver = (?1) AND sender = (?2)", nativeQuery = true)
    void deleteInvitation(String receiver, String sender);
}