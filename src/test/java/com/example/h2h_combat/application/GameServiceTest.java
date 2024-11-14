package com.example.h2h_combat.application;

import com.example.h2h_combat.adapter.out.repository.ElasticGameRepository;
import com.example.h2h_combat.adapter.out.repository.GameJpaRepository;
import com.example.h2h_combat.domain.Game;
import com.example.h2h_combat.domain.GameMO;
import com.example.h2h_combat.domain.Move;
import com.example.h2h_combat.domain.Result;
import com.example.h2h_combat.domain.mappers.GamePostgreMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

public class GameServiceTest {

    @Mock
    private ElasticGameRepository elasticGameRepository;

    @Mock
    private GameJpaRepository gameJpaRepository;

    @Mock
    private GamePostgreMapper gamePostgreMapper;

    @InjectMocks
    private GameService gameService;

    private Game game;
    private GameMO gameMO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        PodamFactory podamFactory = new PodamFactoryImpl();
        gameMO = podamFactory.manufacturePojo(GameMO.class);
        game = podamFactory.manufacturePojo(Game.class);

        // Set fields to match expected test data
        game.setPlayerMove(Move.ROCK);
        game.setComputerMove(Move.PAPER);
        Result result = new Result();
        result.setMessage("CPU wins!");
        result.setWinner("cpu");
        game.setResult(result);
        game.setTitle("Game 1");

        gameMO.setPlayerMove("ROCK");
        gameMO.setComputerMove("PAPER");
        gameMO.setWinner("cpu");
        gameMO.setTitle("Game 1");

        when(gamePostgreMapper.toModel(any(Game.class))).thenReturn(gameMO);
    }

    @Test
    public void testPlay() {
        // Given
        Move playerMove = Move.ROCK;

        // When
        Game resultGame = gameService.play(playerMove);

        // Then
        ArgumentCaptor<Game> gameCaptor = ArgumentCaptor.forClass(Game.class);
        verify(elasticGameRepository).save(gameCaptor.capture());
        Game capturedGame = gameCaptor.getValue();

        assertEquals(game.getTitle(), resultGame.getTitle());
        assertEquals(game.getTitle(), capturedGame.getTitle());
        verify(gameJpaRepository).save(gamePostgreMapper.toModel(game));
    }

    @Test
    public void testGetAllGames() {
        // Given
        when(gameJpaRepository.findAll()).thenReturn(List.of(gameMO));
        when(gamePostgreMapper.fromModel(gameMO)).thenReturn(game);

        // When
        List<Game> resultGames = gameService.getAllGames();

        // Then
        assertEquals(1, resultGames.size());
        assertEquals(game.getTitle(), resultGames.get(0).getTitle());
        verify(gameJpaRepository).findAll();
    }
}
