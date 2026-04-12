package com.marcelo721.rewind_back_end.Adapters.outbound.external.tmdbMovies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TmdbMovieDetailsResponse {

    @JsonProperty("imdb_id")
    private String imdbId;

    public String getImdbId() {
        return imdbId;
    }
}
