package com.marcelo721.rewind_back_end.Adapters.outBound.external.omdb;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.omdb.dto.OmdbMovieResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.omdb.dto.OmdbSearchResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.omdb.mapper.OmdbMovieMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.repositories.MovieProviderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class OmdbMovieProviderImpl implements MovieProviderRepository {

    private final WebClient webClient;

    private String  apiKey  = System.getenv("API_KEY");

    public OmdbMovieProviderImpl(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://www.omdbapi.com").build();
    }

    @Override
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

    @Override
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
