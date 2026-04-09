package com.marcelo721.rewind_back_end.Adapters.outBound.external.GoogleBooks.dto;

import java.util.List;

public class GoogleBooksSearchResponse {
    private List<GoogleBookItem> items;

    public List<GoogleBookItem> getItems() {
        return items;
    }

    public void setItems(List<GoogleBookItem> items) {
        this.items = items;
    }
}
