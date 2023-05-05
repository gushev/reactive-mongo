package com.beats.userdetails.service;

import com.beats.models.request.UserCreateRequest;
import com.beats.models.response.UserCreateResponse;
import com.beats.userdetails.repository.UserRepository;
import com.beats.userdetails.model.User;
import com.beats.userdetails.service.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;
  private final UserMapper mapper;

  public Mono<UserCreateResponse> get(Mono<UUID> userId) {
    return repository.findById(userId)
        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")))
        .map(mapper::toUserCreateResponse);
  }

  public Flux<User> getAll() {
    return repository.findAll();
  }

  public Mono<UserCreateResponse> create(Mono<UserCreateRequest> createRequest) {
    return createRequest.map(mapper::toUserEntity)
        .flatMap(repository::save)
        .map(mapper::toUserCreateResponse);
  }
}
