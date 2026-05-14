package com.marcelo721.rewind_back_end.domain.model.entities;

import com.marcelo721.rewind_back_end.domain.model.enums.FriendshipStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Friendship {

    private UUID id;
    private UUID requesterId;
    private UUID addresseeId;
    private FriendshipStatus status;
    private LocalDateTime createdAt;
}
