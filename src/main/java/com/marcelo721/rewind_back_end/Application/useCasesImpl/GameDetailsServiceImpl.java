package com.marcelo721.rewind_back_end.Application.useCasesImpl;

import com.marcelo721.rewind_back_end.Application.useCases.GameDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.GameSummary;
import com.marcelo721.rewind_back_end.domain.ports.GameProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDetailsServiceImpl implements GameDetailsUseCases {

    private final GameProviderRepository gameProviderRepository;

    public GameDetailsServiceImpl(GameProviderRepository gameProviderRepository) {
        this.gameProviderRepository = gameProviderRepository;
    }

    @Override
    public GameDetails getById(String id) {
        return gameProviderRepository.getById(id);
    }

    @Override
    public List<GameSummary> searchByTitle(String title) {
        return gameProviderRepository.searchByTitle(title);
    }
}
