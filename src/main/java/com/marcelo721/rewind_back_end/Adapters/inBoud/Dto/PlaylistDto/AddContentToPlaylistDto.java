package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.PlaylistDto;

import com.marcelo721.rewind_back_end.domain.model.enums.ContentType;

public record AddContentToPlaylistDto(
        String source,
        String externalId,
        ContentType contentType,
        String title
) {
}
