package com.example.h2h_combat.adapter.in.web;

import com.example.h2h_combat.application.GameService;
import com.example.h2h_combat.domain.Game;
import com.example.h2h_combat.domain.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    private PodamFactory podamFactory;

    @BeforeEach
    void setUp() {
        this.podamFactory = new PodamFactoryImpl();
    }

    @Test
    public void testPlay() throws Exception {
        Move move = Move.ROCK;
        Game game = podamFactory.manufacturePojo(Game.class);
        game.setPlayerMove(move);
        game.setComputerMove(Move.PAPER);
        game.getResult().setMessage("CPU wins!");
        game.getResult().setWinner("cpu");

        when(gameService.play(move)).thenReturn(game);

        this.mockMvc.perform(post("/h2h-combat/play")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content(move.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(game.getId()))
                .andExpect(jsonPath("$.title").value(game.getTitle()))
                .andExpect(jsonPath("$.playerMove").value("ROCK"))
                .andExpect(jsonPath("$.computerMove").value("PAPER"))
                .andExpect(jsonPath("$.result.message").value("CPU wins!"))
                .andExpect(jsonPath("$.result.winner").value("cpu"));
    }
}
