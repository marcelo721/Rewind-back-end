package com.marcelo721.rewind_back_end.Adapters.outBound.repositories.mappers;

import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaContentEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;

public class ContentPersistenceMapper {

    private ContentPersistenceMapper() {}


    public static Content toDomain(JpaContentEntity entity) {
        if (entity == null) return null;

        return new Content(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getReleaseDate(),
                entity.getContentType(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedBy(),
                entity.getExternalId(),
                entity.getSource(),
                entity.getAverageRating(),
                entity.getRatingsCount()
        );
    }

    public static JpaContentEntity toEntity(Content content) {
        if (content == null) return null;

        JpaContentEntity entity = new JpaContentEntity();

        entity.setId(content.getId());
        entity.setTitle(content.getTitle());
        entity.setDescription(content.getDescription());
        entity.setReleaseDate(content.getReleaseDate());
        entity.setContentType(content.getContentType());
        entity.setCreatedAt(content.getCreatedAt());
        entity.setUpdatedAt(content.getUpdatedAt());
        entity.setCreatedBy(content.getCreatedBy());
        entity.setUpdatedBy(content.getUpdatedBy());
        entity.setExternalId(content.getExternalId());
        entity.setSource(content.getSource());
        entity.setAverageRating(content.getAverageRating());
        entity.setRatingsCount(content.getRatingsCount());
        return entity;
    }

}
