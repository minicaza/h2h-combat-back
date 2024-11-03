package com.example.h2h_combat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(indexName = "games")
public class Game {
    private String id;
    private String title;
    private Move playerMove;
    private Move computerMove;
    private Result result;
}
