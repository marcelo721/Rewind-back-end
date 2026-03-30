package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.SeriesDetailsRepositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaSeriesDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaSeriesDetailsRepository extends JpaRepository<JpaSeriesDetailsEntity, UUID> {
}
