package com.marcelo721.rewind_back_end.domain.model.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class GameDetails {

    private UUID id;
    private Content content;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private String status;
    private Integer metaCriticScore;
    private List<String> platforms;
    private List<String> genres;
    private String developer;

    public GameDetails(UUID id, Content content, String title, String description,
                       LocalDate releaseDate, String status, Integer metaCriticScore,
                       List<String> platforms, List<String> genres, String developer) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.status = status;
        this.metaCriticScore = metaCriticScore;
        this.platforms = platforms;
        this.genres = genres;
        this.developer = developer;
    }

    public GameDetails() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMetaCriticScore() {
        return metaCriticScore;
    }

    public void setMetaCriticScore(Integer metaCriticScore) {
        this.metaCriticScore = metaCriticScore;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
