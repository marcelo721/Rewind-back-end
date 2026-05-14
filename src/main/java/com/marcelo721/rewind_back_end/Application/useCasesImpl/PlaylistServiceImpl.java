package com.marcelo721.rewind_back_end.Application.useCasesImpl;

import com.marcelo721.rewind_back_end.Application.command.AddContentToPlaylistCommand;
import com.marcelo721.rewind_back_end.Application.command.CreatePlaylistCommand;
import com.marcelo721.rewind_back_end.Application.useCases.PlaylistUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.Playlist;
import com.marcelo721.rewind_back_end.domain.ports.ContentRepository;
import com.marcelo721.rewind_back_end.domain.ports.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;


@Service
public class PlaylistServiceImpl implements PlaylistUseCases {

    private final PlaylistRepository playlistRepository;
    private final ContentRepository contentRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository,
                               ContentRepository contentRepository) {
        this.playlistRepository = playlistRepository;
        this.contentRepository = contentRepository;
    }

    @Override
    public void create(CreatePlaylistCommand command) {
        Playlist playlist = new Playlist();

        playlist.setDescription(command.description());
        playlist.setEntries(new ArrayList<>());
        playlist.setName(command.name());
        playlist.setPublic(command.isPublic());
        playlist.setOwnerId(command.ownerId());

        playlistRepository.save(playlist);
    }

    @Override
    public void addContent(AddContentToPlaylistCommand command) {
        Playlist playlist = playlistRepository.findById(command.playlistId());

        Content content = contentRepository.findBySourceAndExternalId(command.source(),
                                command.externalId()
                        )
                        .orElseGet(() -> createContent(command));

        playlist.addContent(content);
        playlistRepository.save(playlist);
    }

    @Override
    public Playlist findById(UUID id) {
        return playlistRepository.findById(id);
    }

    private Content createContent(AddContentToPlaylistCommand command) {

        Content content = new Content(UUID.randomUUID(),
                command.contentType(),
                command.source(),
                command.externalId());

        contentRepository.createContent(content);
        return content;
    }
}
