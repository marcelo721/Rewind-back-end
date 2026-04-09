package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.MovieDto;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;

import java.util.List;
import java.util.UUID;

public record MovieResponseDto(
        UUID id,
        String contentId,
        String title,
        String description,
        String director,
        List<String> writers,
        List<String> cast,
        List<String> genres,
        String rated,
        Integer durationMinutes,
        String originalLanguage,
        String country,
        String productionCompany,
        String boxOffice,
        Double imdbRating,
        Integer imdbVotes,
        Integer metascore,
        String awards
) {
    public static MovieResponseDto toDto(MovieDetails entity) {
        return new MovieResponseDto(
                entity.getId(),
                entity.getContent() != null ? entity.getContent().getId().toString() : null,
                entity.getTitle(),
                entity.getDescription(),
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
