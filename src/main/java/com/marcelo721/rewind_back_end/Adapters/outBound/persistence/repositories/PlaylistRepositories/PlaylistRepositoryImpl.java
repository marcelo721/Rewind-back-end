package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.PlaylistRepositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaPlaylistEntity;
import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers.PlaylistPersistenceMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.Playlist;
import com.marcelo721.rewind_back_end.domain.ports.PlaylistRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PlaylistRepositoryImpl implements PlaylistRepository {

    private final JpaPlaylistRepository repository;


    public PlaylistRepositoryImpl(JpaPlaylistRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Playlist playlist) {
        JpaPlaylistEntity jpaEntity  = PlaylistPersistenceMapper.toEntity(playlist);
        repository.save(jpaEntity);
    }

    @Override
    public Playlist findById(UUID id) {
        JpaPlaylistEntity playlist = repository.findById(id).get();
        return PlaylistPersistenceMapper.toDomain(playlist);
    }
}
