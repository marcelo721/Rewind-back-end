package com.marcelo721.rewind_back_end.domain.model.entities;

import java.util.List;

public class BookSummary {

    private String id;
    private String title;
    private List<String> authors;
    private String publisher;

    public BookSummary(String id, String title, List<String> authors, String publisher) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
