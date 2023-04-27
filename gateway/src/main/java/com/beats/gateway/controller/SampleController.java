package com.beats.gateway.controller;

import com.beats.gateway.client.SamplesServiceClient;
import com.beats.models.request.SampleCreateRequest;
import com.beats.models.response.SampleCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.beats.gateway.controller.SampleController.SAMPLES_ENDPOINT;

@RestController
@RequestMapping(SAMPLES_ENDPOINT)
@RequiredArgsConstructor
public class SampleController {

  public static final String SAMPLES_ENDPOINT = "samples";

  private final SamplesServiceClient client;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<SampleCreateResponse> create(@RequestBody Mono<SampleCreateRequest> sampleCreateRequest) {
    return client.create(sampleCreateRequest);
  }
}
