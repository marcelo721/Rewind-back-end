package com.marcelo721.rewind_back_end.Adapters.outBound.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "movie_details")
public class JpaMovieDetailsEntity {
    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "content_id")
    private JpaContentEntity content;


    @Column(name = "director")
    private String director;

    @ElementCollection
    @CollectionTable(name = "movie_writers", joinColumns = @JoinColumn(name = "movie_writers_id"))
    @Column(name = "writers")
    private List<String> writers;

    @ElementCollection
    @CollectionTable(name = "movie_cast", joinColumns = @JoinColumn(name = "movie_cast_id"))
    @Column(name = "cast")
    private List<String> cast;

    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_details_id"))
    @Column(name = "genre")
    private List<String> genres;

    @Column(name = "rated")
    private String rated;

    @Column(name = "duration")
    private Integer durationMinutes;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "country")
    private String country;

    @Column(name ="production_company")
    private String productionCompany;

    @Column(name = "box_office")
    private String boxOffice;

    @Column(name = "imdb_rating")
    private Double imdbRating;

    @Column(name = "imdb_votes")
    private Integer imdbVotes;

    @Column(name = "metascore")
    private Integer metascore;

    @Column(name = "awards")
    private String awards;

    public JpaMovieDetailsEntity() {
    }

    public JpaMovieDetailsEntity(UUID id, JpaContentEntity content, String director, List<String> writers,
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



    public JpaContentEntity getContent() {
        return content;
    }

    public void setContent(JpaContentEntity content) {
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
