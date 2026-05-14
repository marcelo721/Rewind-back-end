package com.marcelo721.rewind_back_end.Application.command;

import java.util.UUID;

public record CreatePlaylistCommand (
        UUID ownerId,
        String name,
        String description,
        Boolean isPublic
){
}
