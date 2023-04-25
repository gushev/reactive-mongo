package com.beats.models.response;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UserCreateResponse {
  UUID id;
  String name;
}
