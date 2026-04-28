package com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.provider;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.client.GoogleBooksClient;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.mapper.GoogleBookItem;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.mapper.GoogleBooksResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.mapper.GoogleBooksSearchResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.mapper.GoogleBooksMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.BookDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.BookSummary;
import com.marcelo721.rewind_back_end.domain.ports.BookProviderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleBookProviderImpl implements BookProviderRepository {

    private final GoogleBooksClient client;

    public GoogleBookProviderImpl(GoogleBooksClient client) {
        this.client = client;
    }


    @Override
    public BookDetails findById(String id) {
        GoogleBooksResponse searchResponse = client.findById(id);
        if(searchResponse == null) return null;
        return GoogleBooksMapper.toBookDetails(searchResponse);
    }

    @Override
    public List<BookSummary> searchByTitle(String title) {
        GoogleBooksSearchResponse response = client.search(title);

        List<BookSummary> books = new ArrayList<>();

        if (response == null || response.getItems() == null) {
            return books;
        }

        for (GoogleBookItem item : response.getItems()) {
            books.add(GoogleBooksMapper.toBookSummary(item));
        }

        return books;
    }
}