package com.marcelo721.rewind_back_end.Application.useCasesImpl;

import com.marcelo721.rewind_back_end.Application.useCases.BookDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.BookDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.BookSummary;
import com.marcelo721.rewind_back_end.domain.ports.BookProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailsServiceImpl implements BookDetailsUseCases {

    private final BookProviderRepository bookProviderRepository;

    public BookDetailsServiceImpl(BookProviderRepository bookProviderRepository) {
        this.bookProviderRepository = bookProviderRepository;
    }


    @Override
    public BookDetails getFromProvider(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id must not be empty");
        }

        return bookProviderRepository.findById(id);
    }

    @Override
    public List<BookSummary> searchByTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be empty");
        }

        return bookProviderRepository.searchByTitle(title);
    }
}
