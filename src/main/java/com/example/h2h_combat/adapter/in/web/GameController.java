package com.example.h2h_combat.adapter.in.web;

import com.example.h2h_combat.application.GameService;
import com.example.h2h_combat.domain.Game;
import com.example.h2h_combat.domain.Move;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/h2h-combat")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/play")
    public ResponseEntity<Game> play(@RequestBody String playerMove) {
        log.info("New game starts");
        Move move = Move.valueOf(playerMove.trim().toUpperCase());
        return ResponseEntity.ok(gameService.play(move));
    }

    @GetMapping("/history")
    public ResponseEntity<List<Game>> gamesPlayed(){
        log.info("Return all games played");
        return ResponseEntity.ok(gameService.getAllGames());
    }
}
