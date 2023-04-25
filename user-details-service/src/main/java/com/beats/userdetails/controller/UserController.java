package com.beats.userdetails.controller;

import com.beats.models.request.UserCreateRequest;
import com.beats.models.response.UserCreateResponse;
import com.beats.userdetails.model.User;
import com.beats.userdetails.service.UserService;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.beats.userdetails.controller.UserController.USERS_ENDPOINT;

@RestController
@RequestMapping(USERS_ENDPOINT)
@RequiredArgsConstructor
public class UserController {

  public static final String USERS_ENDPOINT = "users";

  private final UserService service;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<User> getAll() {
    return service.getAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<UserCreateResponse> create(@RequestBody Mono<UserCreateRequest> userCreateRequest) {
    return service.create(userCreateRequest);
  }
}
