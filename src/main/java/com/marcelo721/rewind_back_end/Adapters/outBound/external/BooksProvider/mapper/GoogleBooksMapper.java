package com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.mapper;

import com.marcelo721.rewind_back_end.domain.model.entities.BookDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.BookSummary;

public class GoogleBooksMapper {

    public static BookDetails toBookDetails(GoogleBooksResponse response) {
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

    public static BookSummary toBookSummary(GoogleBookItem item) {
        VolumeInfo info = item.getVolumeInfo();

        return new BookSummary(
                item.getId(),
                info.getTitle(),
                info.getAuthors(),
                info.getImageLinks() != null ? info.getImageLinks().getThumbnail() : null
        );
    }
}
