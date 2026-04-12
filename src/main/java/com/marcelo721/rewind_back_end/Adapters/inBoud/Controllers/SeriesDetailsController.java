package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;


import com.marcelo721.rewind_back_end.Application.useCases.SeriesDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesSummary;
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
    public List<SeriesSummary> search(@RequestParam String title) {
        return seriesProvider.searchByTitle(title);
    }


    @GetMapping("/{id}")
    public SeriesDetails getDetails(@PathVariable String id) {
        return seriesProvider.getByImdbId(id);
    }
}
