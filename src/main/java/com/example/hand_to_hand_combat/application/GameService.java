package com.example.hand_to_hand_combat.application;

import com.example.hand_to_hand_combat.domain.Move;
import com.example.hand_to_hand_combat.domain.Result;
import com.example.hand_to_hand_combat.domain.Game;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    private final Random random = new Random();

    public Result play(Move playerMove) {
        Move computerMove = getRandomMove();
        Game game = new Game(playerMove, computerMove);
        String winner = game.determineWinner();
        return new Result("Game played", computerMove, winner);
    }

    private Move getRandomMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }
}

