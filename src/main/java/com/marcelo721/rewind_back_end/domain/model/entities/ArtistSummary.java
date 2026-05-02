package com.marcelo721.rewind_back_end.domain.model.entities;

public class ArtistSummary {

    private String name;
    private String id;
    private Long listeners;

    public ArtistSummary(String name, String id, Long listeners) {
        this.name = name;
        this.id = id;
        this.listeners = listeners;
    }

    public ArtistSummary() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getListeners() {
        return listeners;
    }

    public void setListeners(Long listeners) {
        this.listeners = listeners;
    }
}
