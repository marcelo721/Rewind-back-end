package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.UUID;

@Entity
@Table(name = "playlists")
public class JpaPlaylistEntity {

    @Id
    @GeneratedValue
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;

    @Column(nullable = false)
    private UUID ownerId;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false,name = "description")
    private String description;

    @Column(nullable = false, name = "isPublic")
    private Boolean isPublic;

    public JpaPlaylistEntity(Boolean isPublic, String description,
                             String name, UUID ownerId, UUID id) {
        this.isPublic = isPublic;
        this.description = description;
        this.name = name;
        this.ownerId = ownerId;
        this.id = id;
    }
    public JpaPlaylistEntity() {}

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


}
