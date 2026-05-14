package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.BookDto;

import com.marcelo721.rewind_back_end.domain.model.entities.BookSummary;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

public record BookResponseDto(
         String id,
         String title,
         List<String>authors,
         String publisher
) {

    public static BookResponseDto toDto(BookSummary book) {
        return new BookResponseDto(book.getId(),
                book.getTitle(), book.getAuthors(), book.getPublisher());
    }

    public static List<BookResponseDto> toListDto(List<BookSummary> books) {
        return books.stream().map(BookResponseDto::toDto).collect(Collectors.toList());
    }
}
