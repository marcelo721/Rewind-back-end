package com.marcelo721.rewind_back_end.domain.model.entities;

import com.marcelo721.rewind_back_end.domain.model.enums.ContentType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Content {

    private UUID id;
    private LocalDate releaseDate;
    private ContentType contentType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String source;
    private String externalId;
    private Double averageRating;
    private Integer ratingsCount;

    public Content(UUID id, LocalDate releaseDate, ContentType contentType,
                   LocalDateTime createdAt, LocalDateTime updatedAt,
                   String source, String externalId, Double averageRating, Integer ratingsCount) {
        this.id = id;
        this.releaseDate = releaseDate;
        this.contentType = contentType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.source = source;
        this.externalId = externalId;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
    }

    public Content() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }



    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }
}
