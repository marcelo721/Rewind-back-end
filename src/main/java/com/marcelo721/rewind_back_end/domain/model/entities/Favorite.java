package com.marcelo721.rewind_back_end.domain.model.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Favorite {
    private UUID userId;
    private UUID contentId;
    private LocalDateTime createdAt;

    public Favorite(UUID userId, UUID contentId, LocalDateTime createdAt) {
        this.userId = userId;
        this.contentId = contentId;
        this.createdAt = createdAt;
    }

    public Favorite() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getContentId() {
        return contentId;
    }

    public void setContentId(UUID contentId) {
        this.contentId = contentId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
