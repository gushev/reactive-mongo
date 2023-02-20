package com.beats.userdetails.controller;

import com.beats.userdetails.model.User;
import com.beats.userdetails.service.UserService;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.beats.userdetails.controller.UserController.USERS_ENDPOINT;

@RestController
@RequestMapping(USERS_ENDPOINT)
@RequiredArgsConstructor
public class UserController {

  public static final String USERS_ENDPOINT = "users";

  private final UserService service;
  private final EurekaClient eurekaClient;

  @Value("${spring.application.name}")
  private String appName;

  @GetMapping
  public Publisher<User> getAll() {
    return service.getAll();
  }

  @GetMapping("/greeting")
  public Mono<String> greeting() {
    System.out.println("here");
    String idInEureka = eurekaClient.getApplication(appName).getInstances().get(0).getId();
    return Mono.just(String.format("Hello from '%s'!", idInEureka));
  }

  @PostMapping
  public Mono<Boolean> create() {
    System.out.println("here");
    return Mono.just(true);
  }
}
