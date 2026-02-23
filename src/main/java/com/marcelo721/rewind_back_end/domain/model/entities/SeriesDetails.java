package com.marcelo721.rewind_back_end.domain.model.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class SeriesDetails {

    private UUID id;
    private Content content;

    private List<String> creators;
    private List<String> genres;
    private List<String> cast;

    private Integer numberOfSeasons;
    private Integer numberOfEpisodes;
    private String status;

    private LocalDate firstAirDate;
    private LocalDate lastAirDate;

    private String originalLanguage;
    private String country;
    private List<String> streamingPlatforms;

    private Double imdbRating;
    private Integer metascore;

    private String awards;


    public SeriesDetails(UUID id, Content content, List<String> creators, List<String> genres,
                         List<String> cast, Integer numberOfSeasons, Integer numberOfEpisodes, String status,
                         LocalDate firstAirDate, LocalDate lastAirDate, String originalLanguage, String country,
                         List<String> streamingPlatforms, Double imdbRating, Integer metascore, String awards) {
        this.id = id;
        this.content = content;
        this.creators = creators;
        this.genres = genres;
        this.cast = cast;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
        this.status = status;
        this.firstAirDate = firstAirDate;
        this.lastAirDate = lastAirDate;
        this.originalLanguage = originalLanguage;
        this.country = country;
        this.streamingPlatforms = streamingPlatforms;
        this.imdbRating = imdbRating;
        this.metascore = metascore;
        this.awards = awards;
    }

    public SeriesDetails() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<String> getCreators() {
        return creators;
    }

    public void setCreators(List<String> creators) {
        this.creators = creators;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(LocalDate firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public LocalDate getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(LocalDate lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getStreamingPlatforms() {
        return streamingPlatforms;
    }

    public void setStreamingPlatforms(List<String> streamingPlatforms) {
        this.streamingPlatforms = streamingPlatforms;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getMetascore() {
        return metascore;
    }

    public void setMetascore(Integer metascore) {
        this.metascore = metascore;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }
}
