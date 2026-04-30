package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;


import com.marcelo721.rewind_back_end.Application.useCases.SeriesDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/series")
public class SeriesDetailsController {

    private final SeriesDetailsUseCases seriesProvider;

    public SeriesDetailsController(SeriesDetailsUseCases seriesDetailsUseCases) {
        this.seriesProvider = seriesDetailsUseCases;
    }

    @GetMapping("/search")
    public ResponseEntity<List<SeriesSummary>> search(@RequestParam String title) {
        return ResponseEntity.ok(seriesProvider.searchByTitle(title));
    }


    @GetMapping("/{id}")
    public ResponseEntity<SeriesDetails> getDetails(@PathVariable String id) {
        return ResponseEntity.ok(seriesProvider.getByImdbId(id));
    }
}
