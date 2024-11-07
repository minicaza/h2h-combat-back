package com.example.h2h_combat.adapter.in.web;

import com.example.h2h_combat.application.GameService;
import com.example.h2h_combat.domain.Game;
import com.example.h2h_combat.domain.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.mockito.Mockito.when;

//@WebMvcTest(controllers = {GameController.class})
public class GameControllerTest {
/*
    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    private PodamFactory podamFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.podamFactory = new PodamFactoryImpl();
    }

    @Test
    public void testPlay() throws Exception {
        Move move = podamFactory.manufacturePojo(Move.class);
        Game game = podamFactory.manufacturePojo(Game.class);

        when(gameService.play(move)).thenReturn(game);

        Game game1 = gameController.play(String.valueOf(move)).getBody();

        Assertions.assertEquals(game.getId(), game1.getId());
    }*/
}
