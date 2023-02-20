package com.beats.gateway.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(
    name = "${user-details-service.service.name}"
)
public interface UserDetailsServiceClient {
  @PostMapping(value = "/users", headers = {"Content-Type=application/json"})
  Mono<Boolean> createCustomer();

  @GetMapping("/users/greeting")
  Mono<String> greeting();
}
