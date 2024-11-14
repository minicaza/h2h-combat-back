package com.example.h2h_combat.domain;

import com.example.h2h_combat.domain.mappers.GamePostgreMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameTest {

    private PodamFactory podamFactory;

    @BeforeEach
    public void setUp() {
        podamFactory = new PodamFactoryImpl();
    }

    @Test
    public void testGameCreation() {
        // Given
        int id = 1;
        String title = "Game 1";
        Move playerMove = Move.ROCK;
        Move computerMove = Move.PAPER;
        Result result = new Result();
        result.setMessage("CPU wins!");
        result.setWinner("cpu");

        // When
        Game game = new Game(id, title, playerMove, computerMove, result);

        // Then
        assertNotNull(game);
        assertEquals(id, game.getId());
        assertEquals(title, game.getTitle());
        assertEquals(playerMove, game.getPlayerMove());
        assertEquals(computerMove, game.getComputerMove());
        assertEquals(result, game.getResult());
    }

    @Test
    public void testGameSetters() {
        // Given
        Game game = podamFactory.manufacturePojo(Game.class);
        int id = 2;
        String title = "Game 2";
        Move playerMove = Move.SCISSORS;
        Move computerMove = Move.ROCK;
        Result result = new Result();
        result.setMessage("It's a tie!");
        result.setWinner("none");

        // When
        game.setId(id);
        game.setTitle(title);
        game.setPlayerMove(playerMove);
        game.setComputerMove(computerMove);
        game.setResult(result);

        // Then
        assertEquals(id, game.getId());
        assertEquals(title, game.getTitle());
        assertEquals(playerMove, game.getPlayerMove());
        assertEquals(computerMove, game.getComputerMove());
        assertEquals(result, game.getResult());
    }
}
