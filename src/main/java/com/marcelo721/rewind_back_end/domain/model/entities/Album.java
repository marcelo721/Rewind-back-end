package com.marcelo721.rewind_back_end.domain.model.entities;

import java.util.List;

public class Album {
    private String id;
    private String title;
    private String artistName;
    private String releaseDate;

    public Album(String id, String title, String artistName,
                 String releaseDate) {
        this.id = id;
        this.title = title;
        this.artistName = artistName;
        this.releaseDate = releaseDate;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getArtistName() { return artistName; }
    public String getReleaseDate() { return releaseDate; }
}
