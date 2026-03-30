package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaContentEntity;
import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaSeriesDetailsEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;

public class SeriesDetailsPersistenceMapper {

    public static JpaSeriesDetailsEntity toEntity(SeriesDetails domain) {

        if (domain == null) return null;

        JpaSeriesDetailsEntity entity = new JpaSeriesDetailsEntity();
        JpaContentEntity contentJpa = ContentPersistenceMapper.toEntity(domain.getContent());


        entity.setId(domain.getId());
        entity.setContent(contentJpa);

        entity.setCreators(domain.getCreators());
        entity.setGenres(domain.getGenres());
        entity.setCast(domain.getCast());

        entity.setNumberOfSeasons(domain.getNumberOfSeasons());
        entity.setNumberOfEpisodes(domain.getNumberOfEpisodes());

        entity.setStatus(domain.getStatus());

        entity.setFirstAirDate(domain.getFirstAirDate());
        entity.setLastAirDate(domain.getLastAirDate());

        entity.setOriginalLanguage(domain.getOriginalLanguage());
        entity.setCountry(domain.getCountry());

        entity.setStreamingPlatforms(domain.getStreamingPlatforms());

        entity.setImdbRating(domain.getImdbRating());
        entity.setMetascore(domain.getMetascore());
        entity.setAwards(domain.getAwards());
        entity.setTitle(domain.getTitle());
        entity.setDescription(domain.getDescription());

        return entity;
    }

    public static SeriesDetails toDomain(JpaSeriesDetailsEntity entity) {

        if (entity == null) return null;
        Content content = ContentPersistenceMapper.toDomain(entity.getContent());
        return new SeriesDetails(
                entity.getId(),
                content,
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreators(),
                entity.getGenres(),
                entity.getCast(),
                entity.getNumberOfSeasons(),
                entity.getNumberOfEpisodes(),
                entity.getStatus(),
                entity.getFirstAirDate(),
                entity.getLastAirDate(),
                entity.getOriginalLanguage(),
                entity.getCountry(),
                entity.getStreamingPlatforms(),
                entity.getImdbRating(),
                entity.getMetascore(),
                entity.getAwards()
        );
    }

}
