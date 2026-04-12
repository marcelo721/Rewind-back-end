package com.marcelo721.rewind_back_end.Adapters.outbound.external.tmdbMovies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TmdbMovieDto {

    private int id;
    private String title;

    @JsonProperty("poster_path")
    private String posterPath;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
