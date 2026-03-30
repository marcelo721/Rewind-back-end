package com.marcelo721.rewind_back_end.domain.model.entities;

public class MovieSummary {

    private String id;
    private String title;
    private String year;
    private String posterUrl;

    public MovieSummary(String id, String title, String year, String posterUrl) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.posterUrl = posterUrl;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getYear() { return year; }
    public String getPosterUrl() { return posterUrl; }
}
