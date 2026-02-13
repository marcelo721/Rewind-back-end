package com.marcelo721.rewind_back_end.Application.useCases;

import com.marcelo721.rewind_back_end.domain.model.entities.Content;

import java.util.List;
import java.util.UUID;

public interface ContentUseCases {
    Content findById(UUID id);
    void createContent(Content content);
    List<Content> findAll();
}
