package com.beats.samples.service;

import com.beats.samples.model.Sample;
import com.beats.samples.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class SampleService {
  private final SampleRepository repository;

  public Flux<Sample> getAll() {
    return repository.findAll();
  }
}
