package com.marcelo721.rewind_back_end.Adapters.outBound.entities;

import com.marcelo721.rewind_back_end.domain.model.enums.ContentType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "contents")
public class JpaContentEntity extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "content_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "average_rating", nullable = false)
    private Double averageRating;

    @Column(name = "ratings_count", nullable = false)
    private Integer ratingsCount;


    public JpaContentEntity(UUID id, String title, String description, LocalDate releaseDate,
                            ContentType contentType, String source, String externalId, Double averageRating,
                            Integer ratingsCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.contentType = contentType;
        this.source = source;
        this.externalId = externalId;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
    }

    public JpaContentEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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
