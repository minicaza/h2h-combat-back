package com.example.h2h_combat.domain.mappers;

import com.example.h2h_combat.domain.Game;
import com.example.h2h_combat.domain.GameMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GamePostgreMapper {
    @Mapping(target = "id", expression = "java(Long.valueOf(game.getId()))")
    @Mapping(target = "date", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "playerMove", expression = "java(game.getPlayerMove().name())")
    @Mapping(target = "computerMove", expression = "java(game.getComputerMove().name())")
    @Mapping(target = "winner", expression = "java(game.getResult().getWinner())")
    GameMO toModel(Game game);
}
