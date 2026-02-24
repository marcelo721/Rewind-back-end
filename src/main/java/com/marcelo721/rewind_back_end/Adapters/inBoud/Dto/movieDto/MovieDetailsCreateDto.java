package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.movieDto;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.UUID;

public record MovieDetailsCreateDto(

        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull(message = "contentId is required")
        UUID contentId,

        @NotBlank
        String director,

        @NotEmpty
        List<String> writers,

        @NotEmpty
        List<String> cast,

        @NotEmpty
        List<String> genres,

        @NotBlank
        String rated,

        @Positive
        Integer durationMinutes,

        @NotBlank
        String originalLanguage,

        @NotBlank
        String country,

        @NotBlank
        String productionCompany,

        String boxOffice,

        @DecimalMin("0.0")
        @DecimalMax("10.0")
        Double imdbRating,

        @PositiveOrZero
        Integer imdbVotes,

        @PositiveOrZero
        Integer metascore,

        String awards

) {
    public MovieDetails toDomain() {
        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setDirector(director);
        movieDetails.setWriters(writers);
        movieDetails.setCast(cast);
        movieDetails.setGenres(genres);
        movieDetails.setRated(rated);
        movieDetails.setDurationMinutes(durationMinutes);
        movieDetails.setOriginalLanguage(originalLanguage);
        movieDetails.setCountry(country);
        movieDetails.setProductionCompany(productionCompany);
        movieDetails.setBoxOffice(boxOffice);
        movieDetails.setImdbRating(imdbRating);
        movieDetails.setImdbVotes(imdbVotes);
        movieDetails.setMetascore(metascore);
        movieDetails.setAwards(awards);
        movieDetails.setDescription(description);
        movieDetails.setTitle(title);

        return movieDetails;
    }
}
