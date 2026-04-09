package com.marcelo721.rewind_back_end.Adapters.outBound.external.GoogleBooks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VolumeInfo {

    @JsonProperty("title")
    private String title;

    @JsonProperty("authors")
    private List<String> authors;

    @JsonProperty("description")
    private String description;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("publishedDate")
    private String publishedDate;

    @JsonProperty("imageLinks")
    private ImageLinks imageLinks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }
}
