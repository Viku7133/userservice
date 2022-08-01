package com.neosave.userservice.userservice.manager;

import com.neosave.userservice.userservice.entity.UserEntity;
import com.neosave.userservice.userservice.repo.UserRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class UserManager {

  @Autowired
  private UserRepo userRepository;

  /**
   * @param userEntity
   * @return Optional(UserEntity)
   */
  public Optional<UserEntity> save(UserEntity userEntity) {
    if (ObjectUtils.isEmpty(userEntity)) {
      return Optional.empty();
    }
    return Optional.of(userRepository.save(userEntity));
  }


  /**
   * @param userId
   * @return Optional(UserEntity)
   */
  public Optional<UserEntity> getUserEntity(Long userId) {
    if (ObjectUtils.isEmpty(userId)) {
      return Optional.empty();
    }
    return userRepository.findById(userId);
  }

  public Optional<UserEntity> getUserEntityByEmailId(String email) {
    if (ObjectUtils.isEmpty(email)) {
      return Optional.empty();
    }
    return userRepository.findByEmailId(email);
  }

}

