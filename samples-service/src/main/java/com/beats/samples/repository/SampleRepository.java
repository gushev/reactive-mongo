package com.beats.samples.repository;

import com.beats.samples.model.Sample;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SampleRepository extends ReactiveCrudRepository<Sample, UUID> {
}
