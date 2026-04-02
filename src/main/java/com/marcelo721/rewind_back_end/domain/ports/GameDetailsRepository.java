package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;

import java.util.List;
import java.util.UUID;

public interface GameDetailsRepository {
    GameDetails findById(UUID id);
    void create(GameDetails gameDetails);
    List<GameDetails> findAll();
}
