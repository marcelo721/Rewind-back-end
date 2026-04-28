package com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.client;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.mapper.GoogleBooksResponse;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.mapper.GoogleBooksSearchResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GoogleBooksClient {

    private final WebClient webClient;
    private final String apiKey = System.getenv("BOOKS_API");

    public GoogleBooksClient(WebClient.Builder builder) {
        this.webClient = builder
            .baseUrl("https://www.googleapis.com/books/v1")
            .build();
    }

    public GoogleBooksResponse findById(String id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/volumes/{id}")
                        .queryParam("key", apiKey)
                        .build(id))
                .retrieve()
                .bodyToMono(GoogleBooksResponse.class)
                .block();
    }

    public GoogleBooksSearchResponse search(String title) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/volumes")
                        .queryParam("q", "intitle:" + title)
                        .queryParam("key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(GoogleBooksSearchResponse.class)
                .block();
    }
}
