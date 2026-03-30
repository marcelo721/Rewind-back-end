package com.marcelo721.rewind_back_end.Application.useCasesImpl;

import com.marcelo721.rewind_back_end.Application.useCases.GameDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import com.marcelo721.rewind_back_end.domain.repositories.GameDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameDetailsServiceImpl implements GameDetailsUseCases {

    private final GameDetailsRepository gameDetailsRepository;


    public GameDetailsServiceImpl(GameDetailsRepository gameDetailsRepository) {
        this.gameDetailsRepository = gameDetailsRepository;
    }

    @Override
    public GameDetails findById(UUID id) {
        return gameDetailsRepository.findById(id);
    }

    @Override
    public void create(GameDetails gameDetails) {
        gameDetailsRepository.create(gameDetails);
    }

    @Override
    public List<GameDetails> findAll() {
        return gameDetailsRepository.findAll();
    }
}
