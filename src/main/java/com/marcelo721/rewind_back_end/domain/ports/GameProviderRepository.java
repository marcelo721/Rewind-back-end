package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.GameSummary;


import java.util.List;

public interface GameProviderRepository {

    GameDetails getById(String id);
    List<GameSummary> searchByTitle(String title);
}
