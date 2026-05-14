package com.marcelo721.rewind_back_end.Application.command;

import com.marcelo721.rewind_back_end.domain.model.enums.ContentType;

import java.util.UUID;

public record AddContentToPlaylistCommand(
        UUID playlistId,
        String source,
        String externalId,
        ContentType contentType,
        String title
) {
}
