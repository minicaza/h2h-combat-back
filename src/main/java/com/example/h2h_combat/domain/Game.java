package com.example.h2h_combat.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@Document(indexName = "games")
public class Game {
    private String id;
    private String title;
    private Move playerMove;
    private Move computerMove;

    public String determineWinner() {
        if (playerMove == computerMove) {
            return "It's a tie!";
        }
        return switch (playerMove) {
            case ROCK -> (computerMove == Move.SCISSORS) ? "Player wins!" : "Computer wins!";
            case PAPER -> (computerMove == Move.ROCK) ? "Player wins!" : "Computer wins!";
            case SCISSORS -> (computerMove == Move.PAPER) ? "Player wins!" : "Computer wins!";
        };
    }
}
