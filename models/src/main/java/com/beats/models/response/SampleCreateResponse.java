package com.beats.models.response;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class SampleCreateResponse {
  UUID id;
  UUID userId;
  String name;
}

