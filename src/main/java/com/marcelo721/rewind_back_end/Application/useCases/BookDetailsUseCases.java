package com.marcelo721.rewind_back_end.Application.useCases;

import com.marcelo721.rewind_back_end.domain.model.entities.BookDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.BookSummary;

import java.util.List;

public interface BookDetailsUseCases {

    BookDetails getFromProvider(String id);
    List<BookSummary> searchByTitle(String title);
}
