package com.marcelo721.rewind_back_end.domain.model.entities;

public class Track {
    private String id;
    private String title;
    private int duration;

    public Track(String id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
}
