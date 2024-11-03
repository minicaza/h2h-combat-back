package com.example.h2h_combat.adapter.in.web.GameController;

import com.example.h2h_combat.application.GameService;
import com.example.h2h_combat.domain.Game;
import com.example.h2h_combat.domain.Move;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/h2h-combat")
public class GameController {

    private final GameService gameService;

    @PostMapping("/play")
    public ResponseEntity<Game> play(@RequestBody String playerMove) {
        Move move = Move.valueOf(playerMove.trim().toUpperCase());
        return ResponseEntity.ok(gameService.play(move));
    }

}
