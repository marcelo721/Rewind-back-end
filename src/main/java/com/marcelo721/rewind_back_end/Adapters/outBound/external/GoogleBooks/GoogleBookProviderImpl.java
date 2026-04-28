package com.marcelo721.rewind_back_end.Adapters.outBound.external.GoogleBooks;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.GoogleBooks.dto.GoogleBookItem;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.GoogleBooks.dto.GoogleBooksResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.GoogleBooks.dto.GoogleBooksSearchResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.GoogleBooks.dto.VolumeInfo;
import com.marcelo721.rewind_back_end.domain.model.entities.BookDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.BookSummary;
import com.marcelo721.rewind_back_end.domain.ports.BookProviderRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleBookProviderImpl implements BookProviderRepository {

    private final WebClient webClient;
    private  String apiKey = System.getenv("BOOKS_API");

    public GoogleBookProviderImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://www.googleapis.com/books/v1")
                .build();
    }

    @Override
    public BookDetails findById(String id) {
        GoogleBooksResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/volumes/{id}")
                        .queryParam("key", apiKey)
                        .build(id))
                .retrieve()
                .bodyToMono(GoogleBooksResponse.class)
                .block();

        if (response == null) return null;

        return mapToBookDetails(response);
    }

    @Override
    public List<BookSummary> searchByTitle(String title) {
        GoogleBooksSearchResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/volumes")
                        .queryParam("q", "intitle:" + title)
                        .queryParam("key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(GoogleBooksSearchResponse.class)
                .block();

        List<BookSummary> books = new ArrayList<>();

        if (response == null || response.getItems() == null) {
            return books;
        }

        for (GoogleBookItem item : response.getItems()) {
            books.add(mapToBookSummary(item));
        }

        return books;
    }

    private BookDetails mapToBookDetails(GoogleBooksResponse response) {
        VolumeInfo info = response.getVolumeInfo();

        return new BookDetails(
                info.getTitle(),
                info.getAuthors(),
                info.getDescription(),
                info.getImageLinks() != null ? info.getImageLinks().getThumbnail() : null,
                info.getPublisher(),
                info.getPublishedDate()
        );
    }

    private BookSummary mapToBookSummary(GoogleBookItem item) {
        VolumeInfo info = item.getVolumeInfo();

        return new BookSummary(
                item.getId(),
                info.getTitle(),
                info.getAuthors(),
                info.getImageLinks() != null ? info.getImageLinks().getThumbnail() : null
        );
    }
}