package com.marcelo721.rewind_back_end.Adapters.outBound.external.omdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OmdbMovieResponse {

    @JsonProperty("Title")
    public String title;

    @JsonProperty("Plot")
    public String plot;

    @JsonProperty("Director")
    public String director;

    @JsonProperty("Writer")
    public String writer;

    @JsonProperty("Actors")
    public String actors;

    @JsonProperty("Genre")
    public String genre;

    @JsonProperty("Rated")
    public String rated;

    @JsonProperty("Runtime")
    public String runtime;

    @JsonProperty("Language")
    public String language;

    @JsonProperty("Country")
    public String country;

    @JsonProperty("Production")
    public String production;

    @JsonProperty("BoxOffice")
    public String boxOffice;

    @JsonProperty("imdbRating")
    public String imdbRating;

    @JsonProperty("imdbVotes")
    public String imdbVotes;

    @JsonProperty("Metascore")
    public String metascore;

    @JsonProperty("Awards")
    public String awards;

    @JsonProperty("Year")
    public String year;

    @JsonProperty("imdbID")
    public String imdbID;

    @JsonProperty("Poster")
    public String poster;
}
