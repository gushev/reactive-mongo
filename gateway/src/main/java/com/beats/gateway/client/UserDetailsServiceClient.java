package com.beats.gateway.client;

import com.beats.models.request.UserCreateRequest;
import com.beats.models.response.UserCreateResponse;
import com.beats.userdetails.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(
    name = "${user-details-service.service.name}"
)
public interface UserDetailsServiceClient {
  @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
  Flux<User> getAll();

  @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Mono<UserCreateResponse> create(@RequestBody Mono<UserCreateRequest> userCreateRequest);
}
