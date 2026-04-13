package com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.omdbMovies;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.omdbMovies.dto.OmdbMovieResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.omdbMovies.dto.OmdbSearchResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.omdbMovies.mapper.OmdbMovieMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class OmdbMovieProvider {

    private final WebClient webClient;

    private String  apiKey  = System.getenv("API_KEY");

    public OmdbMovieProvider(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://www.omdbapi.com").build();
    }

    public MovieDetails getByImdbId(String imdbId) {

        OmdbMovieResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("i", imdbId)
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(OmdbMovieResponse.class)
                .block();

        return OmdbMovieMapper.toDomain(response);
    }

    public List<MovieSummary> searchByTitle(String title) {

        OmdbSearchResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("s", title)
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(OmdbSearchResponse.class)
                .block();

        if (response == null || response.getSearch() == null || response.getSearch().isEmpty()) {
            return List.of();
        }
        return response.getSearch()
                .stream()
                .map(OmdbMovieMapper::toSummary)
                .toList();
    }
}
