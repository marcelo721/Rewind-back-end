package com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbMovies;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbMovies.client.TmdbMovieClient;
import com.marcelo721.rewind_back_end.Adapters.outbound.external.tmdbMovies.dto.TmdbMovieDetailsResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class MovieExternalService {
    private final TmdbMovieClient client;

    public MovieExternalService(TmdbMovieClient client) {
        this.client = client;
    }

    @Cacheable(value = "tmdb-imdb", key = "#tmdbId")
    public String getImdbId(int tmdbId) {
        TmdbMovieDetailsResponse response = client.getMovieDetails(tmdbId);
        return response != null ? response.getImdbId() : null;
    }
}
