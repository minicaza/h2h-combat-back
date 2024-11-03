package com.example.h2h_combat.adapter.out.repository;

import com.example.h2h_combat.domain.GameMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameJpaRepository extends JpaRepository<GameMO, String> {
}
