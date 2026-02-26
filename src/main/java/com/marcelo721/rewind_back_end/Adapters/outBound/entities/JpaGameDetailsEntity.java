package com.marcelo721.rewind_back_end.Adapters.outBound.entities;

import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "game_details")
public class JpaGameDetailsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "content_id", nullable = false)
    private JpaContentEntity content;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "status")
    private String status;

    @Column(name = "metacritic_score")
    private Integer metaCriticScore;

    @CollectionTable(name = "game_platforms", joinColumns = @JoinColumn(name = "game_details_id"))
    @Column(name = "platform")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> platforms;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "game_genres", joinColumns = @JoinColumn(name = "game_details_id"))
    @Column(name = "genre")
    private List<String> genres;

    @Column(name = "developer")
    private String developer;

    public JpaGameDetailsEntity() {
    }

    public JpaGameDetailsEntity(UUID id, JpaContentEntity content, String title, String description,
                                LocalDate releaseDate, String status, Integer metaCriticScore,
                                List<String> platforms, List<String> genres, String developer) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.status = status;
        this.metaCriticScore = metaCriticScore;
        this.platforms = platforms;
        this.genres = genres;
        this.developer = developer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public JpaContentEntity getContent() {
        return content;
    }

    public void setContent(JpaContentEntity content) {
        this.content = content;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMetaCriticScore() {
        return metaCriticScore;
    }

    public void setMetaCriticScore(Integer metaCriticScore) {
        this.metaCriticScore = metaCriticScore;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
