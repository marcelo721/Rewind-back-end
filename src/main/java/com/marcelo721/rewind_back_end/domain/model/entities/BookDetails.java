package com.marcelo721.rewind_back_end.domain.model.entities;

import java.util.List;

public class BookDetails {

    private String id;
    private String title;
    private List<String> authors;
    private String description;
    private String thumbnail;
    private String publisher;
    private String publishedDate;

    public BookDetails (String id, String title, List<String> authors, String description, String thumbnail, String publisher, String publishedDate) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.thumbnail = thumbnail;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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
}
