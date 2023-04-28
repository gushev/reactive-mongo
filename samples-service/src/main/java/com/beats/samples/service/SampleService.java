package com.beats.samples.service;

import com.beats.models.request.SampleCreateRequest;
import com.beats.models.response.SampleCreateResponse;
import com.beats.samples.model.Sample;
import com.beats.samples.repository.SampleRepository;
import com.beats.samples.service.util.SampleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SampleService {
  private final SampleRepository repository;
  private final SampleMapper mapper;

  public Flux<Sample> getAll() {
    return repository.findAll();
  }

  public Mono<SampleCreateResponse> create(Mono<SampleCreateRequest> createRequest) {
    return createRequest.map(mapper::toEntity)
        .flatMap(repository::save)
        .map(mapper::toCreateResponse);
  }
}
