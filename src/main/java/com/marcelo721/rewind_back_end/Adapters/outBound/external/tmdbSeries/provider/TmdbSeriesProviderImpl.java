package com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbSeries.provider;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbSeries.client.OmdbClient;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbSeries.client.TmdbClient;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbSeries.mapper.SeriesMapper;

import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesSummary;
import com.marcelo721.rewind_back_end.domain.ports.SeriesProviderRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class TmdbSeriesProviderImpl implements SeriesProviderRepository {

    private final TmdbClient tmdbClient;
    private final OmdbClient omdbClient;
    private final SeriesMapper mapper;

    private final String IMAGE_BASE = "https://image.tmdb.org/t/p/w500";

    public TmdbSeriesProviderImpl(
            TmdbClient tmdbClient,
            OmdbClient omdbClient,
            SeriesMapper mapper
    ) {
        this.tmdbClient = tmdbClient;
        this.omdbClient = omdbClient;
        this.mapper = mapper;
    }

    @Override
    public List<SeriesSummary> searchByTitle(String title) {
        Map response = tmdbClient.searchSeries(title);

        List<Map<String, Object>> results =
                (List<Map<String, Object>>) response.get("results");

        return results.stream()
                .map(item -> mapper.toSummary(item, IMAGE_BASE))
                .toList();
    }

    @Override
    public SeriesDetails getByImdbId(String id) {

        // =========================
        // 🎬 1. Dados principais (TMDb)
        // =========================
        Map<String, Object> response = tmdbClient.getSeriesDetails(id);

        String title = (String) response.get("name");
        String description = (String) response.get("overview");

        Integer seasons = (Integer) response.get("number_of_seasons");
        Integer episodes = (Integer) response.get("number_of_episodes");

        String posterPath = (String) response.get("poster_path");
        String posterUrl = posterPath != null ? IMAGE_BASE + posterPath : null;

        String status = (String) response.get("status");
        String language = (String) response.get("original_language");

        LocalDate firstAirDate = mapper.parseDate((String) response.get("first_air_date"));
        LocalDate lastAirDate = mapper.parseDate((String) response.get("last_air_date"));

        List<String> genres = ((List<Map<String, Object>>) response.get("genres"))
                .stream().map(g -> (String) g.get("name")).toList();

        List<String> creators = ((List<Map<String, Object>>) response.get("created_by"))
                .stream().map(c -> (String) c.get("name")).toList();

        // =========================
        // 📺 2. Plataformas (CORRIGIDO)
        // =========================
        List<String> streamingPlatforms = List.of();

        Map<String, Object> providersResponse = tmdbClient.getWatchProviders(id);

        if (providersResponse != null) {
            Map<String, Object> results =
                    (Map<String, Object>) providersResponse.get("results");

            if (results != null && results.containsKey("BR")) {

                Map<String, Object> br =
                        (Map<String, Object>) results.get("BR");

                List<Map<String, Object>> flatrate =
                        (List<Map<String, Object>>) br.get("flatrate");

                if (flatrate != null) {
                    streamingPlatforms = flatrate.stream()
                            .map(p -> (String) p.get("provider_name"))
                            .toList();
                }
            }
        }

        // =========================
        // 🔗 3. IMDb ID
        // =========================
        Map<String, Object> external = tmdbClient.getExternalIds(id);
        String imdbId = (String) external.get("imdb_id");

        // =========================
        // 🏆 4. OMDb (rating + awards)
        // =========================
        Double rating = null;
        String awards = null;

        if (imdbId != null) {
            Map<String, Object> omdb = omdbClient.getByImdbId(imdbId);

            if (omdb != null && !"False".equals(omdb.get("Response"))) {

                awards = (String) omdb.get("Awards");

                String ratingStr = (String) omdb.get("imdbRating");
                if (ratingStr != null && !"N/A".equals(ratingStr)) {
                    rating = Double.valueOf(ratingStr);
                }
            }
        }

        // =========================
        // 🎯 Resultado final
        // =========================
        return new SeriesDetails(
                posterUrl,
                title,
                description,
                creators,
                genres,
                List.of(), // cast ainda não implementado
                seasons,
                episodes,
                status,
                firstAirDate,
                lastAirDate,
                language,
                null,
                streamingPlatforms,
                rating,
                null,
                awards
        );
    }
}