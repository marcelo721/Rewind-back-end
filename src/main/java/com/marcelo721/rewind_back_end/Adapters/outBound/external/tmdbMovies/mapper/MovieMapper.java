package com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbMovies.mapper;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbMovies.Dto.TmdbMovieDto;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    private final String IMAGE_BASE = "https://image.tmdb.org/t/p/w500";


    public MovieSummary toSummary(TmdbMovieDto movie, String imdbId) {
        return new MovieSummary(
                imdbId,
                movie.getTitle(),
                null,
                buildPosterUrl(movie.getPosterPath())
        );
    }

    private String buildPosterUrl(String posterPath) {
        return posterPath != null ? IMAGE_BASE + posterPath : null;
    }
}
