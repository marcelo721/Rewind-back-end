package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaContentEntity;
import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaGameDetailsEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;

public class GameDetailsPersistenceMapper {

    private GameDetailsPersistenceMapper(){}

    public static GameDetails toDomain(JpaGameDetailsEntity entity){
        if(entity == null) return null;

        Content content = ContentPersistenceMapper.toDomain(entity.getContent());

        return new GameDetails(
                entity.getId(),
                content,
                entity.getTitle(),
                entity.getDescription(),
                entity.getReleaseDate(),
                entity.getStatus(),
                entity.getMetaCriticScore(),
                entity.getPlatforms(),
                entity.getGenres(),
                entity.getDeveloper()
        );
    }

    public static JpaGameDetailsEntity toEntity(GameDetails domain){
        if(domain == null) return null;

        JpaContentEntity contentEntity =
                ContentPersistenceMapper.toEntity(domain.getContent());

        return new JpaGameDetailsEntity(
                domain.getId(),
                contentEntity,
                domain.getTitle(),
                domain.getDescription(),
                domain.getReleaseDate(),
                domain.getStatus(),
                domain.getMetaCriticScore(),
                domain.getPlatforms(),
                domain.getGenres(),
                domain.getDeveloper()
        );
    }
}
