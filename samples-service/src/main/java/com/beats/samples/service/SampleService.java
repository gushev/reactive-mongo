package com.beats.samples.service;

import com.beats.models.request.SampleCreateRequest;
import com.beats.models.response.SampleCreateResponse;
import com.beats.samples.model.Sample;
import com.beats.samples.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SampleService {
  private final SampleRepository repository;

  public Flux<Sample> getAll() {
    return repository.findAll();
  }

  public Mono<SampleCreateResponse> create(Mono<SampleCreateRequest> createRequest) {
    return createRequest.map(this::mapCreateRequestToSample)
        .flatMap(repository::save)
        .map(this::mapUserToUserCreatedResponse);
  }

  private Sample mapCreateRequestToSample(SampleCreateRequest request) {
    return Sample.builder()
        .id(UUID.randomUUID())
        .userId(request.getUserId())
        .name(request.getName())
        .build();
  }

  private SampleCreateResponse mapUserToUserCreatedResponse(Sample sample) {
    return SampleCreateResponse.builder()
        .id(sample.getId())
        .userId(sample.getUserId())
        .name(sample.getName())
        .build();
  }
}
