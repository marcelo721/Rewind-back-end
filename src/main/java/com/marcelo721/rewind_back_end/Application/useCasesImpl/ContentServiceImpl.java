package com.marcelo721.rewind_back_end.Application.useCasesImpl;


import com.marcelo721.rewind_back_end.Application.useCases.ContentUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.ports.ContentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ContentServiceImpl implements ContentUseCases {

    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Content findById(UUID id) {
        return contentRepository.findById(id);
    }

    @Override
    @Transactional
    public void createContent(Content content) {

        content.setAverageRating(0.0);
        content.setRatingsCount(0);
        contentRepository.createContent(content);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Content> findAll() {
        return contentRepository.findAll();
    }
}
