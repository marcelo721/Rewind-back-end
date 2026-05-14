package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.BookDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.BookSummary;

import java.util.List;

public interface BookProviderRepository {
    BookDetails findById(String id);
    List<BookSummary> searchByTitle(String title);
}
