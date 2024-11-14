package com.example.h2h_combat.domain.mappers;

import com.example.h2h_combat.domain.Game;
import com.example.h2h_combat.domain.GameMO;
import com.example.h2h_combat.domain.Move;
import com.example.h2h_combat.domain.Result;
import com.example.h2h_combat.domain.mappers.GamePostgreMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GamePostgreMapperTest {

    private GamePostgreMapper gamePostgreMapper;
    private PodamFactory podamFactory;

    @BeforeEach
    public void setUp() {
        gamePostgreMapper = Mappers.getMapper(GamePostgreMapper.class);
        podamFactory = new PodamFactoryImpl();
    }

    @Test
    public void testToModel() {
        // Given
        Game game = podamFactory.manufacturePojo(Game.class);
        game.setId(1);
        game.setPlayerMove(Move.ROCK);
        game.setComputerMove(Move.PAPER);
        Result result = new Result();
        result.setMessage("CPU wins!");
        result.setWinner("cpu");
        game.setResult(result);

        // When
        GameMO gameMO = gamePostgreMapper.toModel(game);

        // Then
        assertNotNull(gameMO);
        assertEquals(game.getId(), gameMO.getId());
        assertEquals("ROCK", gameMO.getPlayerMove());
        assertEquals("PAPER", gameMO.getComputerMove());
        assertEquals("cpu", gameMO.getWinner());
        assertNotNull(gameMO.getDate());
    }

    @Test
    public void testFromModel() {
        // Given
        GameMO gameMO = podamFactory.manufacturePojo(GameMO.class);
        gameMO.setId(1L);
        gameMO.setPlayerMove("ROCK");
        gameMO.setComputerMove("PAPER");
        gameMO.setWinner("cpu");

        // When
        Game game = gamePostgreMapper.fromModel(gameMO);

        // Then
        assertNotNull(game);
        assertEquals(gameMO.getId().longValue(), game.getId());
        assertEquals("Game " + gameMO.getId(), game.getTitle());
        assertEquals(Move.ROCK, game.getPlayerMove());
        assertEquals(Move.PAPER, game.getComputerMove());
        assertEquals("cpu", game.getResult().getWinner());
        assertEquals("", game.getResult().getMessage()); //gameMO does not have message
    }
}
