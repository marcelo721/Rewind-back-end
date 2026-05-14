package com.marcelo721.rewind_back_end.Application.useCases;

import com.marcelo721.rewind_back_end.Application.command.AddContentToPlaylistCommand;
import com.marcelo721.rewind_back_end.Application.command.CreatePlaylistCommand;
import com.marcelo721.rewind_back_end.domain.model.entities.Playlist;

import java.util.UUID;

public interface PlaylistUseCases {
    void create(CreatePlaylistCommand command);
    void addContent(AddContentToPlaylistCommand command);
    Playlist findById(UUID id);
}
