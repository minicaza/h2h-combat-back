package com.example.h2h_combat.application;

import com.example.h2h_combat.adapter.out.repository.ElasticGameRepository;
import com.example.h2h_combat.domain.Move;
import com.example.h2h_combat.domain.Result;
import com.example.h2h_combat.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private int gameCount;
    private final Random random = new Random();
    @Autowired
    private ElasticGameRepository elasticGameRepository;

    public Result play(Move playerMove) {
        gameCount++;
        Move computerMove = getRandomMove();
        Game game = new Game("game"+gameCount, "game", playerMove, computerMove);
        String winner = game.determineWinner();
        elasticGameRepository.save(game);
        return new Result("Game played", computerMove, winner);
    }

    private Move getRandomMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }
}

