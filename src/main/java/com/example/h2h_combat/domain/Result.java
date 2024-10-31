package com.example.h2h_combat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result {

    private String message;
    private Move computerMove;
    private String winner;
}

