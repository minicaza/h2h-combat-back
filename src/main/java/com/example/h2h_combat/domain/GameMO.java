package com.example.h2h_combat.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "game")
public class GameMO {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime date;

    @Column(name = "title")
    private String title;

    @Column(name = "player_move")
    private String playerMove;

    @Column(name = "computer_move")
    private String computerMove;

    @Column(name = "winner")
    private String winner;
}
