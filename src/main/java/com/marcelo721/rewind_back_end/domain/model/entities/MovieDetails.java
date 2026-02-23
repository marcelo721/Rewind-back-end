package com.marcelo721.rewind_back_end.domain.model.entities;

import java.util.List;
import java.util.UUID;

public class MovieDetails {

    private UUID id;
    private Content content;

    private String director;
    private List<String> writers;
    private List<String> cast;

    private List<String> genres;
    private String rated; // PG-13, R, etc

    private Integer durationMinutes;
    private String originalLanguage;
    private String country;

    private String productionCompany;

    private String boxOffice;

    private Double imdbRating;
    private Integer imdbVotes;
    private Integer metascore;

    private String awards;


    public MovieDetails(UUID id, Content content, String director, List<String> writers,
                        List<String> cast, List<String> genres, String rated, Integer durationMinutes,
                        String originalLanguage, String country, String productionCompany, String boxOffice,
                        Double imdbRating, Integer imdbVotes, Integer metascore, String awards) {
        this.id = id;
        this.content = content;
        this.director = director;
        this.writers = writers;
        this.cast = cast;
        this.genres = genres;
        this.rated = rated;
        this.durationMinutes = durationMinutes;
        this.originalLanguage = originalLanguage;
        this.country = country;
        this.productionCompany = productionCompany;
        this.boxOffice = boxOffice;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.metascore = metascore;
        this.awards = awards;
    }

    public MovieDetails() {
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
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

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(Integer imdbVotes) {
        this.imdbVotes = imdbVotes;
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
