package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.Playlist;

import java.util.Optional;
import java.util.UUID;

public interface PlaylistRepository {
    void save(Playlist playlist);
    Playlist findById(UUID id);
}
