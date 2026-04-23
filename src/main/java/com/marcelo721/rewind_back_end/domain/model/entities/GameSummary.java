package com.marcelo721.rewind_back_end.domain.model.entities;

public class GameSummary {

    private String id;
    private String title;
    private String year;
    private String image;

    public GameSummary(String id, String title, String year, String image) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = image;
    }

    public GameSummary() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
