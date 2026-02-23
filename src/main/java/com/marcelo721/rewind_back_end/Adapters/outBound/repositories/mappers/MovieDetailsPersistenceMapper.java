package com.marcelo721.rewind_back_end.Adapters.outBound.repositories.mappers;

import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaContentEntity;
import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaMovieDetailsEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;

public class MovieDetailsPersistenceMapper {

    private MovieDetailsPersistenceMapper(){
    }

    public static MovieDetails toDomain(JpaMovieDetailsEntity entity){
        if(entity == null) return null;

        Content content = ContentPersistenceMapper.toDomain(entity.getContent());
        return new MovieDetails(
                entity.getId(),
                content,
                entity.getDirector(),
                entity.getWriters(),
                entity.getCast(),
                entity.getGenres(),
                entity.getRated(),
                entity.getDurationMinutes(),
                entity.getOriginalLanguage(),
                entity.getCountry(),
                entity.getProductionCompany(),
                entity.getBoxOffice(),
                entity.getImdbRating(),
                entity.getImdbVotes(),
                entity.getMetascore(),
                entity.getAwards()
        );
    }

    public static JpaMovieDetailsEntity toEntity(MovieDetails entity){
        if(entity == null) return null;

        JpaContentEntity contentEntity = ContentPersistenceMapper.toEntity(entity.getContent());
        return new JpaMovieDetailsEntity(
                entity.getId(),
                contentEntity,
                entity.getDirector(),
                entity.getWriters(),
                entity.getCast(),
                entity.getGenres(),
                entity.getRated(),
                entity.getDurationMinutes(),
                entity.getOriginalLanguage(),
                entity.getCountry(),
                entity.getProductionCompany(),
                entity.getBoxOffice(),
                entity.getImdbRating(),
                entity.getImdbVotes(),
                entity.getMetascore(),
                entity.getAwards()
        );
    }
}
