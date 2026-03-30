package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaContentEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;

public class ContentPersistenceMapper {

    private ContentPersistenceMapper() {}


    public static Content toDomain(JpaContentEntity entity) {
        if (entity == null) return null;

        return new Content(
                entity.getId(),
                entity.getContentType(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getSource(),
                entity.getExternalId(),
                entity.getAverageRating(),
                entity.getRatingsCount()
        );
    }

    public static JpaContentEntity toEntity(Content content) {
        if (content == null) return null;

        JpaContentEntity entity = new JpaContentEntity();

        entity.setId(content.getId());
        entity.setContentType(content.getContentType());
        entity.setCreatedAt(content.getCreatedAt());
        entity.setUpdatedAt(content.getUpdatedAt());
        entity.setExternalId(content.getExternalId());
        entity.setSource(content.getSource());
        entity.setAverageRating(content.getAverageRating());
        entity.setRatingsCount(content.getRatingsCount());
        return entity;
    }

}
