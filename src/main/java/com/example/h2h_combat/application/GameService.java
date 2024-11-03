package com.example.h2h_combat.application;

import com.example.h2h_combat.adapter.out.repository.ElasticGameRepository;
import com.example.h2h_combat.adapter.out.repository.GameJpaRepository;
import com.example.h2h_combat.domain.Game;
import com.example.h2h_combat.domain.Move;
import com.example.h2h_combat.domain.Result;
import com.example.h2h_combat.domain.mappers.GamePostgreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private int gameCount;
    private final Random random = new Random();
    private final ElasticGameRepository elasticGameRepository;
    private final GameJpaRepository repository;
    private final GamePostgreMapper mapper;

    @Autowired
    public GameService(ElasticGameRepository elasticGameRepository,
                       GameJpaRepository repository,
                       GamePostgreMapper mapper) {
        this.elasticGameRepository = elasticGameRepository;
        this.repository = repository;
        this.mapper = mapper;
    }

    public Game play(Move playerMove) {
        gameCount++;
        Move computerMove = getRandomMove();
        Game game = new Game(gameCount, "Game "+gameCount, playerMove, computerMove, null);
        determineWinner(game);
        elasticGameRepository.save(game);
        repository.save(mapper.toModel(game));
        return game;
    }

    private Move getRandomMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }

    private void determineWinner(Game game) {
        Result result = new Result();
        Move playerMove = game.getPlayerMove();
        Move computerMove = game.getComputerMove();
        if (playerMove == computerMove) {
            result.setMessage("It's a tie!");
        } else if ((playerMove == Move.ROCK && computerMove == Move.SCISSORS) ||
                (playerMove == Move.PAPER && computerMove == Move.ROCK) ||
                (playerMove == Move.SCISSORS && computerMove == Move.PAPER)){
                    result.setMessage("Player wins!");
                    result.setWinner("Player");
        } else{
            result.setMessage("CPU wins!");
            result.setWinner("CPU");
        }
        game.setResult(result);
    }
}