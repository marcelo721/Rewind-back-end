package com.marcelo721.rewind_back_end.domain.model.entities;

import java.util.List;

public class Artist {

    private String id;
    private String name;
    private String biography;
    private List<String> genres;
    private long listeners;
    private long playCount;

    public Artist(String id, String name, String biography, List<String> genres,
                  long listeners, long playCount) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.genres = genres;
        this.listeners = listeners;
        this.playCount = playCount;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getBiography() { return biography; }
    public List<String> getGenres() { return genres; }
    public long getListeners() { return listeners; }
    public long getPlayCount() { return playCount; }
}
