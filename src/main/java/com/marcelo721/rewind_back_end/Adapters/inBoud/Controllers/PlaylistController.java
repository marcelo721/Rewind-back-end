package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.PlaylistDto.PlaylistCreateDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.PlaylistDto.AddContentToPlaylistDto;
import com.marcelo721.rewind_back_end.Application.command.AddContentToPlaylistCommand;
import com.marcelo721.rewind_back_end.Application.command.CreatePlaylistCommand;
import com.marcelo721.rewind_back_end.Application.useCases.PlaylistUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Playlist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistUseCases useCases;
    public PlaylistController(PlaylistUseCases createPlaylistUseCase) {
        this.useCases = createPlaylistUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody PlaylistCreateDto request) {
        CreatePlaylistCommand command =
                new CreatePlaylistCommand(
                        UUID.randomUUID(),
                        request.name(),
                        request.description(),
                        request.isPublic()
                );

        useCases.create(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{playlistId}/contents")
    public ResponseEntity<Void> addContent(@PathVariable UUID playlistId, @RequestBody AddContentToPlaylistDto request
    ) {
        AddContentToPlaylistCommand command =
                new AddContentToPlaylistCommand(
                        playlistId,
                        request.source(),
                        request.externalId(),
                        request.contentType(),
                        request.title()
                );

        useCases.addContent(command);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Playlist> findById(@PathVariable UUID playlistId) {
        return ResponseEntity.ok(useCases.findById(playlistId));
    }
}