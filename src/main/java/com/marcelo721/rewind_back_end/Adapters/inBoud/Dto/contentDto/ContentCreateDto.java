package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.contentDto;

import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.enums.ContentType;
import jakarta.validation.constraints.NotNull;

public record ContentCreateDto(
     @NotNull
     ContentType contentType,

     @NotNull
     String source,

     @NotNull
     String externalId
) {

    public Content toEntity(){
        Content content = new Content();
        content.setContentType(contentType);
        content.setSource(source);
        content.setExternalId(externalId);
        return content;
    }
}
