package com.marcelo721.rewind_back_end.domain.repositories;

import com.marcelo721.rewind_back_end.domain.model.entities.Content;

import java.util.List;
import java.util.UUID;

public interface ContentRepository {
    Content findById(UUID id);
    void createContent(Content content);
    List<Content> findAll();
}
