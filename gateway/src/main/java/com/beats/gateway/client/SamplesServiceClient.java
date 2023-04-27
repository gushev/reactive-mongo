package com.beats.gateway.client;

import com.beats.models.request.SampleCreateRequest;
import com.beats.models.response.SampleCreateResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(
    name = "${samples-service.service.name}"
)
public interface SamplesServiceClient {
  @PostMapping(value = "/samples", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Mono<SampleCreateResponse> create(@RequestBody Mono<SampleCreateRequest> sampleCreateRequest);
}
