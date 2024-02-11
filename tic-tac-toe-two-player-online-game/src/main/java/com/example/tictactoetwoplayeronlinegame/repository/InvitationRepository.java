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
    @Query(value = "SELECT senders FROM invitation WHERE receiver = (?1)", nativeQuery = true)
    public List<String> getInvitation(String receiver);

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE invitation SET senders = (?2) WHERE receiver = (?1)", nativeQuery = true)
//    public void sendInvitation(String receiver, List<String> senders);

    @Modifying
    @Query(value = "UPDATE invitation SET senders = :senders WHERE receiver = :receiver", nativeQuery = true)
    void sendInvitation(@Param("receiver") String receiver, @Param("senders") String[] senders);

}