package com.example.h2h_combat.adapter.out.repository;

import com.example.h2h_combat.domain.Game;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticGameRepository extends ElasticsearchRepository<Game, String> {
}