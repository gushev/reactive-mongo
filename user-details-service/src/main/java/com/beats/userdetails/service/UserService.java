package com.beats.userdetails.service;

import com.beats.userdetails.repository.UserRepository;
import com.beats.userdetails.model.User;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;

  public Flux<User> getAll() {
    return repository.findAll();
  }
}
