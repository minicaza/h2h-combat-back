package com.example.h2h_combat.adapter.in.web.GameController;

import com.example.h2h_combat.application.GameService;
import com.example.h2h_combat.domain.Move;
import com.example.h2h_combat.domain.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/h2h-combat")
public class GameController {

    private final GameService gameService;

    @PostMapping("/play")
    public ResponseEntity<Result> play(@RequestBody String playerMove) {
        Move move = Move.valueOf(playerMove.trim().toUpperCase());
        Result result = gameService.play(move);
        return ResponseEntity.ok(result);
    }

}
