package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Application.useCases.BookDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.BookDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.BookSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDetailsUseCases BookuseCases;

    public BookController( BookDetailsUseCases bookService) {
        this.BookuseCases = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookSummary>> searchBooks(@RequestParam String title) {
        return ResponseEntity.ok(BookuseCases.searchByTitle(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetails> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(BookuseCases.getFromProvider(id));
    }
}
