package com.marcelo721.rewind_back_end.domain.model.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class PlaylistEntry {
    private UUID id;
    private UUID playlistId;
    private Content content;
    private Integer position;
    private LocalDateTime addedAt;


    public PlaylistEntry(UUID id, UUID playlistId, Content content,
                         Integer position, LocalDateTime addedAt) {
        this.id = id;
        this.playlistId = playlistId;
        this.content = content;
        this.position = position;
        this.addedAt = addedAt;
    }

    public PlaylistEntry() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(UUID playlistId) {
        this.playlistId = playlistId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
