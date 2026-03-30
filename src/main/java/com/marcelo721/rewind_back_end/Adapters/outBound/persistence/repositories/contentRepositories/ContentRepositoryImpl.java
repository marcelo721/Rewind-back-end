package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.contentRepositories;



import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers.ContentPersistenceMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.repositories.ContentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ContentRepositoryImpl implements ContentRepository {

    private final JpaContentRepository contentRepository;

    public ContentRepositoryImpl(JpaContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public Content findById(UUID id) {
        return this.contentRepository.findById(id)
                .map(ContentPersistenceMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void createContent(Content content) {
        this.contentRepository.save(
                ContentPersistenceMapper.toEntity(content)
        );
    }

    @Override
    public List<Content> findAll() {
        return this.contentRepository.findAll()
                .stream()
                .map(ContentPersistenceMapper::toDomain)
                .toList();
    }


}
