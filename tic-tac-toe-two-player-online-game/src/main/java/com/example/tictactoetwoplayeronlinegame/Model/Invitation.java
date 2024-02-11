package com.example.tictactoetwoplayeronlinegame.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invitation {
    @Id
    @SequenceGenerator(
            name = "invitation_sequence",
            sequenceName = "invitation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invitation_sequence"
    )
    private Long id;
    private String receiver;
    private List<String> senders;
}
