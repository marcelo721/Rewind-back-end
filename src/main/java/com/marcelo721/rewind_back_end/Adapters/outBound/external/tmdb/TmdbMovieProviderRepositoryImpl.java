package com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdb;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdb.Dto.TmdbMovieDetailsResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdb.Dto.TmdbSearchResponse;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.ports.MovieGenreProviderRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Objects;

@Component
public class TmdbMovieProviderRepositoryImpl implements MovieGenreProviderRepository {

    private  WebClient webClient;
    private  String apiKey;

    public TmdbMovieProviderRepositoryImpl(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.themoviedb.org/3")
                .build();

        this.apiKey = System.getenv("API_KEY_TMDB");
    }

    @Override
    public List<MovieSummary> searchByGenre(String genre, int page) {

        int genreId = mapGenreToId(genre);

        TmdbSearchResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/discover/movie")
                        .queryParam("with_genres", genreId)
                        .queryParam("api_key", apiKey)
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(TmdbSearchResponse.class)
                .block();

        if (response == null || response.getResults() == null) {
            return List.of();
        }

        return response.getResults()
                .stream()
                .limit(10) // 🔥 reduz chamadas externas
                .map(movie -> {
                    String imdbId = getImdbId(movie.getId());

                    if (imdbId == null) return null;

                    return new MovieSummary(
                            imdbId,
                            movie.getTitle(),
                            null,
                            buildPosterUrl(movie.getPosterPath())
                    );
                })
                .filter(Objects::nonNull)
                .toList();
    }

    @Cacheable(value = "tmdb-imdb", key = "#tmdbId") // 🔥 cache correto
    public String getImdbId(int tmdbId) {

        TmdbMovieDetailsResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/movie/" + tmdbId) // 🔥 endpoint correto
                        .queryParam("api_key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(TmdbMovieDetailsResponse.class)
                .block();

        return response != null ? response.getImdbId() : null;
    }

    private String buildPosterUrl(String posterPath) {
        if (posterPath == null) return null;
        return "https://image.tmdb.org/t/p/w500" + posterPath;
    }

    // 🔥 Mapeamento básico (pode melhorar depois)
    private int mapGenreToId(String genre) {
        return switch (genre.toLowerCase()) {
            case "action" -> 28;
            case "comedy" -> 35;
            case "drama" -> 18;
            case "horror" -> 27;
            case "romance" -> 10749;
            case "animation" -> 16;
            default -> 28;
        };
    }
}
