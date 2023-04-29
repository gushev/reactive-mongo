package com.beats.gateway.controller;

import com.beats.gateway.client.SamplesServiceClient;
import com.beats.gateway.client.UserDetailsServiceClient;
import com.beats.models.request.SampleCreateRequest;
import com.beats.models.response.SampleCreateResponse;
import com.beats.models.response.UserCreateResponse;
import com.beats.userdetails.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

  private final UserDetailsServiceClient userDetailsClient;
  private final SamplesServiceClient client;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<SampleCreateResponse> create(@RequestBody Mono<SampleCreateRequest> sampleCreateRequest) {
    return client.create(sampleCreateRequest);
  }
}
