package com.marcelo721.rewind_back_end.Adapters.outbound.external.tmdbSeries.mapper;


import com.marcelo721.rewind_back_end.domain.model.entities.SeriesSummary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class SeriesMapper {

    public SeriesSummary toSummary(Map<String, Object> item, String imageBase) {
        String id = String.valueOf(item.get("id"));
        String name = (String) item.get("name");
        String date = (String) item.get("first_air_date");
        String poster = (String) item.get("poster_path");

        String year = (date != null && !date.isEmpty()) ? date.substring(0, 4) : "N/A";
        String posterUrl = poster != null ? imageBase + poster : null;

        return new SeriesSummary(id, name, year, posterUrl);
    }

    public LocalDate parseDate(String date) {
        try {
            return (date != null && !date.isEmpty()) ? LocalDate.parse(date) : null;
        } catch (Exception e) {
            return null;
        }
    }
}
