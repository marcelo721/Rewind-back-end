package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.movieDto;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record MovieResponseDto(

        UUID id,

        UUID contentId,

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

    public static MovieResponseDto toDto(MovieDetails movie) {

        UUID contentId = movie.getContent() != null
                ? movie.getContent().getId()
                : null;

        return new MovieResponseDto(
                movie.getId(),
                contentId,
                movie.getTitle(),
                movie.getDescription(),
                movie.getDirector(),
                movie.getWriters(),
                movie.getCast(),
                movie.getGenres(),
                movie.getRated(),
                movie.getDurationMinutes(),
                movie.getOriginalLanguage(),
                movie.getCountry(),
                movie.getProductionCompany(),
                movie.getBoxOffice(),
                movie.getImdbRating(),
                movie.getImdbVotes(),
                movie.getMetascore(),
                movie.getAwards()
        );
    }

    public static List<MovieResponseDto> toListDto(List<MovieDetails> movies) {
        List<MovieResponseDto> list = new ArrayList<>();

        for (MovieDetails movie : movies) {
            list.add(toDto(movie));
        }
        return list;
    }
}
