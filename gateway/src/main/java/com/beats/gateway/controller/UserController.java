package com.beats.gateway.controller;

import com.beats.gateway.client.UserDetailsServiceClient;
import com.beats.models.request.UserCreateRequest;
import com.beats.userdetails.model.User;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.beats.gateway.controller.UserController.USERS_ENDPOINT;

@RestController
@RequestMapping(USERS_ENDPOINT)
@RequiredArgsConstructor
public class UserController {

  public static final String USERS_ENDPOINT = "users";

  private final UserDetailsServiceClient client;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Publisher<User> getAll() {
    return client.getAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Void> create(@RequestBody Publisher<UserCreateRequest> userCreateRequest) {
    System.out.println(userCreateRequest);
    return  Mono.fromRunnable(() -> {});
    //return client.create(userCreateRequest);
  }
}
