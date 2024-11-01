package com.example.h2h_combat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Result {

    private String message;
    private Move computerMove;
    private String winner;
}

