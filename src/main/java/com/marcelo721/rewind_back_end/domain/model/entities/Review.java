package com.marcelo721.rewind_back_end.domain.model.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Review {

    private UUID id;
    private UUID userId;
    private UUID contentId;
    private Integer rating;
    private String text;
    private LocalDateTime createdAt;


    public Review(UUID id, UUID userId, UUID contentId, Integer rating,
                  String text, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.contentId = contentId;
        this.rating = rating;
        this.text = text;
        this.createdAt = createdAt;
    }

    public Review() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
