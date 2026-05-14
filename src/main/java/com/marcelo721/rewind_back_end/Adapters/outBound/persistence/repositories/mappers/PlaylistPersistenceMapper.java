package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaPlaylistEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.Playlist;

import java.util.ArrayList;

public class PlaylistPersistenceMapper {
    public static JpaPlaylistEntity toEntity(Playlist playlist) {

        JpaPlaylistEntity entity = new JpaPlaylistEntity();

        entity.setId(playlist.getId());
        entity.setOwnerId(playlist.getOwnerId());
        entity.setName(playlist.getName());
        entity.setDescription(playlist.getDescription());
        entity.setPublic(playlist.getPublic());

        return entity;
    }

    public  static Playlist toDomain(JpaPlaylistEntity entity) {

        return new Playlist(
                entity.getId(),
                entity.getOwnerId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPublic(),
                new ArrayList<>()
        );
    }
}
