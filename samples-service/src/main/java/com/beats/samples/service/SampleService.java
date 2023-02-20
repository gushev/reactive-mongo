package com.beats.samples.service;

import com.beats.samples.model.Sample;
import com.beats.samples.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {
  private final SampleRepository repository;

  public Publisher<Sample> getAll() {
    return repository.findAll();
  }
}
