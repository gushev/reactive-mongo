package com.beats.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
@Builder
public class SampleCreateResponse {
  UUID id;
  UUID userId;
  String name;
}

