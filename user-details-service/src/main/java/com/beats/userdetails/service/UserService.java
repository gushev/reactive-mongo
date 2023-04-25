package com.beats.userdetails.service;

import com.beats.models.request.UserCreateRequest;
import com.beats.models.response.UserCreateResponse;
import com.beats.userdetails.repository.UserRepository;
import com.beats.userdetails.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;

  public Flux<User> getAll() {
    return repository.findAll();
  }

  public Mono<UserCreateResponse> create(Mono<UserCreateRequest> createRequest) {
    return createRequest.map(this::mapCreateRequestToUser)
        .flatMap(repository::save)
        .map(this::mapUserToUserCreatedResponse);
  }

  private User mapCreateRequestToUser(UserCreateRequest request) {
    return User.builder()
        .id(UUID.randomUUID())
        .name(request.getName())
        .build();
  }

  private UserCreateResponse mapUserToUserCreatedResponse(User user) {
    return UserCreateResponse.builder()
        .id(user.getId())
        .name(user.getName())
        .build();
  }
}
