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
    public List<String> getInvitation(String username){
        logger.info("getInvitation invoked");
        List<String> senders = invitationRepository.getInvitation(username);
        if(senders.contains(null)) return new ArrayList();
        return senders;
    }

    public String sendInvitation(InvitationRequest invitationRequest){
        if(invitationAlreadySent(invitationRequest)){
            logger.info("Already invitation sent to this user");
            return "You have already sent invitation to this user";
        }

        List<String> sendersList = getInvitation(invitationRequest.receiver);
        sendersList.add(invitationRequest.sender);
        String[] sendersArray = sendersList.toArray(new String[0]);
        invitationRepository.sendInvitation(invitationRequest.receiver, sendersArray);
        logger.info("Invitation Sent");
        return "Invitation Sent";
    }

    private boolean invitationAlreadySent(InvitationRequest invitationRequest){
        List<String> sendersList = getInvitation(invitationRequest.receiver);
        for(String sender: sendersList){
            if(sender.equals(invitationRequest.sender)) return true;
        }
        return false;
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
        List<String> sendersList = getInvitation(receiver);
        sendersList.remove(sender);
        String[] sendersArray = sendersList.toArray(new String[0]);
        invitationRepository.sendInvitation(receiver, sendersArray);
    }
}
