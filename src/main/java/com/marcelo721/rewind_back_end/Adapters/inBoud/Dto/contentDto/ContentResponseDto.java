package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.contentDto;

import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.enums.ContentType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record ContentResponseDto(
        UUID id,
        ContentType contentType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String source,
        String externalId,
        Double averageRating,
        Integer ratingsCount

) {

    public static ContentResponseDto toDto(Content content) {
        return new ContentResponseDto(
                content.getId(),
                content.getContentType(),
                content.getCreatedAt(),
                content.getUpdatedAt(),
                content.getSource(),
                content.getExternalId(),
                content.getAverageRating(),
                content.getRatingsCount()
        );
    }
    public static List<ContentResponseDto> toListDto(List<Content> contentList) {
        List<ContentResponseDto> list = new ArrayList<>();

        for (Content g : contentList) {
            list.add(toDto(g));
        }
        return list;
    }
}
