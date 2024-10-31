package com.example.h2h_combat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Game {
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
