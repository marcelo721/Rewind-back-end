package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.PlaylistRepositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaPlaylistEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaPlaylistRepository extends JpaRepository<JpaPlaylistEntity, UUID> {

}
