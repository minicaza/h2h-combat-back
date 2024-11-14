package com.example.h2h_combat.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTest {

    @Test
    public void testEnumValues() {
        // Given
        Move rock = Move.ROCK;
        Move paper = Move.PAPER;
        Move scissors = Move.SCISSORS;

        // Then
        assertEquals("ROCK", rock.name());
        assertEquals("PAPER", paper.name());
        assertEquals("SCISSORS", scissors.name());
    }

    @Test
    public void testEnumValueOf() {
        // When
        Move move = Move.valueOf("ROCK");

        // Then
        assertEquals(Move.ROCK, move);
    }

    @Test
    public void testInvalidEnumValueOf() {
        // When/Then
        assertThrows(IllegalArgumentException.class, () -> {
            Move.valueOf("INVALID");
        });
    }
}
