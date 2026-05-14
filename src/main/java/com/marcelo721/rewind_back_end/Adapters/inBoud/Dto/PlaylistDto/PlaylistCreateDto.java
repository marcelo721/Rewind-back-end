package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.PlaylistDto;

public record PlaylistCreateDto(
        String name,
        String description,
        Boolean isPublic
) {
}
