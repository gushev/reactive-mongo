package com.beats.samples.controller;

import com.beats.samples.model.Sample;
import com.beats.samples.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {
  private final SampleService service;

  @GetMapping("test")
  public Publisher<Sample> getAll() {
    return service.getAll();
  }
}
