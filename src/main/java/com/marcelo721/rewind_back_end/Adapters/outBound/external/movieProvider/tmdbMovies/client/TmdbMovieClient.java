package com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.tmdbMovies.client;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.tmdbMovies.Dto.TmdbSearchResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.tmdbMovies.Dto.TmdbMovieDetailsResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TmdbMovieClient {

    private final WebClient webClient;
    private final String apiKey = System.getenv("API_KEY_TMDB");

    public TmdbMovieClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.themoviedb.org/3")
                .build();
    }

    public TmdbSearchResponse discoverByGenre(int genreId, int page) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/discover/movie")
                        .queryParam("with_genres", genreId)
                        .queryParam("api_key", apiKey)
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(TmdbSearchResponse.class)
                .block();
    }

    public TmdbMovieDetailsResponse getMovieDetails(int tmdbId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/movie/" + tmdbId)
                        .queryParam("api_key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(TmdbMovieDetailsResponse.class)
                .block();
    }
}
