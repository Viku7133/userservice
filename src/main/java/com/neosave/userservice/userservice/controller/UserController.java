package com.neosave.userservice.userservice.controller;

import com.neosave.userservice.userservice.entity.UserEntity;
import com.neosave.userservice.userservice.exception.CustomException;
import com.neosave.userservice.userservice.response.CreateUserResponse;
import com.neosave.userservice.userservice.response.GetUserResponse;
import com.neosave.userservice.userservice.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/create")
  public CreateUserResponse createUser(@RequestParam("name") String userName,
      @RequestParam("email") String email,
      @RequestParam("pin-code") String pinCode) throws CustomException {
    UserEntity userEntity = userService.createUserProfile(userName, email, pinCode);
    return CreateUserResponse
        .builder()
        .userId(Long.toString(userEntity.getId()))
        .build();
  }

  @GetMapping(value = "/{userId}")
  public GetUserResponse getUser(@NonNull @PathVariable Long userId) throws CustomException {
    UserEntity userEntity = userService.getUserProfile(userId);
    return GetUserResponse.builder()
        .userName(userEntity.getName())
        .emailId(userEntity.getEmailId())
        .pinCode(userEntity.getPinCode())
        .state(userEntity.getState())
        .build();
  }


}
