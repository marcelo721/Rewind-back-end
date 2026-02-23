package com.marcelo721.rewind_back_end.Adapters.outBound.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "series_details")
public class JpaSeriesDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "content_id")
    private JpaContentEntity content;

    @ElementCollection
    @CollectionTable(name = "creators", joinColumns = @JoinColumn(name = "series_creators_id"))
    private List<String> creators;

    @ElementCollection
    @CollectionTable(name = "series_genres", joinColumns = @JoinColumn(name = "series_details_id"))
    @Column(name = "genre")
    private List<String> genres;

    @ElementCollection
    @CollectionTable(name = "series_cast", joinColumns = @JoinColumn(name = "series_cast_id"))
    @Column(name = "actors")
    private List<String> cast;

    @Column(name = "number_of_seasons")
    private Integer numberOfSeasons;

    @Column(name = "number_of_episodes")
    private Integer numberOfEpisodes;

    @Column(name = "status")
    private String status;

    @Column(name = "first_air_date")
    private LocalDate firstAirDate;

    @Column(name = "last_air_date")
    private LocalDate lastAirDate;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "country")
    private String country;

    @Column(name = "streaming_platforms")
    private List<String> streamingPlatforms;

    @Column(name = "imdb_rating")
    private Double imdbRating;

    @Column(name = "metascore")
    private Integer metascore;

    @Column(name = "awards")
    private String awards;

    public JpaSeriesDetailsEntity(UUID id, JpaContentEntity content, List<String> creators, List<String> genres,
                                  List<String> cast, Integer numberOfSeasons, Integer numberOfEpisodes,
                                  String status, LocalDate firstAirDate, LocalDate lastAirDate,
                                  String originalLanguage, String country, List<String> streamingPlatforms,
                                  Double imdbRating, Integer metascore, String awards) {
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

    public JpaSeriesDetailsEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public JpaContentEntity getContent() {
        return content;
    }

    public void setContent(JpaContentEntity content) {
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
