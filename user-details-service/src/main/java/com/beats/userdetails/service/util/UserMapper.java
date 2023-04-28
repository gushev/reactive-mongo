package com.beats.userdetails.service.util;

import com.beats.models.request.UserCreateRequest;
import com.beats.models.response.UserCreateResponse;
import com.beats.userdetails.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
  User toUserEntity(UserCreateRequest userCreateRequest);

  UserCreateResponse toUserCreateResponse(User user);
}
