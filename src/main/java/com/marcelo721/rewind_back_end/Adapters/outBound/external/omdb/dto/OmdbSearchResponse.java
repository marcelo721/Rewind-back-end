package com.marcelo721.rewind_back_end.Adapters.outBound.external.omdb.dto;

import java.util.List;

public class OmdbSearchResponse {

    private List<OmdbMovieResponse> Search;

    public List<OmdbMovieResponse> getSearch() {
        return Search;
    }

    public void setSearch(List<OmdbMovieResponse> search) {
        Search = search;
    }
}