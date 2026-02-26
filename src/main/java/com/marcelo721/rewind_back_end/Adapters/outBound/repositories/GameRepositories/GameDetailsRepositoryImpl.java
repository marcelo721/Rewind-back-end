package com.marcelo721.rewind_back_end.Adapters.outBound.repositories.GameRepositories;


import com.marcelo721.rewind_back_end.Adapters.outBound.repositories.mappers.GameDetailsPersistenceMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import com.marcelo721.rewind_back_end.domain.repositories.GameDetailsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class GameDetailsRepositoryImpl implements GameDetailsRepository {

    private final JpaGameDetailsRepository gameDetailsRepository;

    public GameDetailsRepositoryImpl(JpaGameDetailsRepository gameDetailsRepository) {
        this.gameDetailsRepository = gameDetailsRepository;
    }

    @Override
    public GameDetails findById(UUID id) {
        return this.gameDetailsRepository.findById(id)
                .map(GameDetailsPersistenceMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void create(GameDetails gameDetails) {
        this.gameDetailsRepository.save(
                GameDetailsPersistenceMapper.toEntity(gameDetails)
        );
    }

    @Override
    public List<GameDetails> findAll() {
        return this.gameDetailsRepository.findAll()
                .stream()
                .map(GameDetailsPersistenceMapper::toDomain)
                .toList();
    }
}
