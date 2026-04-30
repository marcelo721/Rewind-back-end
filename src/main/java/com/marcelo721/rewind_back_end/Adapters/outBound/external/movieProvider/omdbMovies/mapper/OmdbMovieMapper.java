package com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.omdbMovies.mapper;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.omdbMovies.dto.OmdbMovieResponse;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class OmdbMovieMapper {

    public static MovieDetails toDomain(OmdbMovieResponse dto) {

        List<String> writers = split(dto.writer);
        List<String> cast = split(dto.actors);
        List<String> genres = split(dto.genre);

        return new MovieDetails(
                dto.poster,
                dto.title,
                dto.plot,
                dto.director,
                writers,
                cast,
                genres,
                dto.rated,
                parseRuntime(dto.runtime),
                dto.language,
                dto.country,
                dto.production,
                dto.boxOffice,
                parseDouble(dto.imdbRating),
                parseInt(dto.imdbVotes),
                parseInt(dto.metascore),
                dto.awards
        );
    }

    private static List<String> split(String value) {
        return value != null ? Arrays.asList(value.split(", ")) : null;
    }

    private static Integer parseRuntime(String runtime) {
        try {
            return Integer.parseInt(runtime.replace(" min", ""));
        } catch (Exception e) {
            return null;
        }
    }

    private static Double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }

    private static Integer parseInt(String value) {
        try {
            return Integer.parseInt(value.replace(",", ""));
        } catch (Exception e) {
            return null;
        }
    }

    public static MovieSummary toSummary(OmdbMovieResponse dto) {
        return new MovieSummary(
                dto.imdbID,
                dto.title,
                dto.year,
                dto.poster
        );
    }


}
