package com.marcelo721.rewind_back_end.domain.model.entities;

import java.time.LocalDate;
import java.util.List;

public class GameDetails {

    private String title;
    private String description;
    private LocalDate releaseDate;
    private List<String> genres;
    private List<String> plataforms;
    private Double rating;
    private String image;

    public GameDetails(String title, String description,
                       LocalDate releaseDate,
                       List<String> genres,List<String> plataforms, Double rating, String image) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.plataforms = plataforms;
        this.rating = rating;
        this.image = image;
    }

    public GameDetails() {
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<String> getPlataforms() {
        return plataforms;
    }

    public void setPlataforms(List<String> plataforms) {
        this.plataforms = plataforms;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
