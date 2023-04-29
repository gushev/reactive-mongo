package com.beats.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
public class UserCreateResponse {
  UUID id;
  String name;
}
