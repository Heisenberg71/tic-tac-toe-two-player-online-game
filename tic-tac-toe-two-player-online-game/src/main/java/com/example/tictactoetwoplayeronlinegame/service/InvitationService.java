package com.example.tictactoetwoplayeronlinegame.service;

import com.example.tictactoetwoplayeronlinegame.dto.InvitationRequest;
import com.example.tictactoetwoplayeronlinegame.repository.InvitationRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class InvitationService {
    final static Logger logger = LoggerFactory.getLogger(InvitationService.class);
    @Autowired
    InvitationRepository invitationRepository;

    public List<String> getInvitation(String receiver){
        logger.info("getInvitation invoked");
        List<String> senders = invitationRepository.getInvitation(receiver);
        if(senders.contains(null)) return new ArrayList();
        return senders;
    }

    public String sendInvitation(InvitationRequest invitationRequest){
        invitationRepository.sendInvitation(invitationRequest.receiver, invitationRequest.sender);
        logger.info("Invitation Sent");
        return "Invitation Sent";
    }

    public String acceptInvitation(InvitationRequest invitationRequest){
        deleteSenderFromReceiverList(invitationRequest.sender, invitationRequest.receiver);
        logger.info("Invitation Accepted");
        return "Invitation Accepted";
    }

    public String rejectInvitation(InvitationRequest invitationRequest){
        deleteSenderFromReceiverList(invitationRequest.sender, invitationRequest.receiver);
        logger.info("Invitation Rejected");
        return "Invitation Rejected";
    }

    void deleteSenderFromReceiverList(String sender, String receiver){
        invitationRepository.deleteInvitation(receiver, sender);
        logger.info("Invitation is deleted");
    }
}
