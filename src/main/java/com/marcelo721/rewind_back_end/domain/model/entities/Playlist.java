package com.marcelo721.rewind_back_end.domain.model.entities;

import org.apache.catalina.LifecycleState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Playlist {
    private UUID id;
    private UUID ownerId;
    private String name;
    private String description;
    private Boolean isPublic;

    private List<PlaylistEntry> entries;


    public Playlist(UUID id,UUID ownerId, String name, String description,
                    Boolean isPublic, List<PlaylistEntry> entries) {
        this.ownerId = ownerId;
        this.name = name;
        this.id = id;
        this.description = description;
        this.isPublic = isPublic;
        this.entries = entries;
    }

    public Playlist() {
    }

    public void addContent(Content content) {

        boolean alreadyExists = entries.stream()
                .anyMatch(entry ->
                        entry.getContent()
                                .getId()
                                .equals(content.getId()));

        if (alreadyExists) {
            throw new RuntimeException("Content already exists in playlist");
        }

        PlaylistEntry entry = new PlaylistEntry(
                UUID.randomUUID(),
                this.id,
                content,
                entries.size() + 1,
                LocalDateTime.now()
        );

        entries.add(entry);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public List<PlaylistEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<PlaylistEntry> entries) {
        this.entries = entries;
    }
}
