package com.example.tictactoetwoplayeronlinegame.service;

import com.example.tictactoetwoplayeronlinegame.dto.InvitationRequest;
import com.example.tictactoetwoplayeronlinegame.repository.InvitationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class InvitationServiceTest {
    @Mock
    private InvitationRepository invitationRepository;
    @InjectMocks
    private InvitationService invitationService;

    @Test
    void getInvitation() {
        List<String> senders = new ArrayList<>();
        senders.add("rasel");
        senders.add("mamun");
        when(invitationRepository.getInvitation(any())).thenReturn(senders);

        List<String> expectedResults = new ArrayList<>();
        expectedResults.add("rasel");
        expectedResults.add("mamun");

        List<String> actualResults = invitationService.getInvitation("samin");

        assertEquals(expectedResults, actualResults);
    }

    @Test
    void sendInvitation() {
        var invitationRequest = InvitationRequest.builder()
                .receiver("samin")
                .sender("rasel")
                .build();

        String actualResult = invitationService.sendInvitation(invitationRequest);
        verify(invitationRepository, times(1)).sendInvitation("samin", "rasel");
        assertEquals("Invitation Sent", actualResult);
    }

    @Test
    void acceptInvitation() {
        var invitationRequest = InvitationRequest.builder()
                .receiver("samin")
                .sender("rasel")
                .build();

        String actualResult = invitationService.acceptInvitation(invitationRequest);
        verify(invitationRepository, times(1)).deleteInvitation("samin", "rasel");
        assertEquals("Invitation Accepted", actualResult);
    }

    @Test
    void rejectInvitation() {
        var invitationRequest = InvitationRequest.builder()
                .receiver("samin")
                .sender("rasel")
                .build();

        String actualResult = invitationService.rejectInvitation(invitationRequest);
        verify(invitationRepository, times(1)).deleteInvitation("samin", "rasel");
        assertEquals("Invitation Rejected", actualResult);
    }
}