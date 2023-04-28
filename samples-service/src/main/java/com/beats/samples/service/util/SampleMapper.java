package com.beats.samples.service.util;

import com.beats.models.request.SampleCreateRequest;
import com.beats.models.response.SampleCreateResponse;
import com.beats.samples.model.Sample;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SampleMapper {

  @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
  Sample toEntity(SampleCreateRequest request);

  SampleCreateResponse toCreateResponse(Sample entity);
}
