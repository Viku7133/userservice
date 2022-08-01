package com.neosave.userservice.userservice.repo;

import com.neosave.userservice.userservice.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {

  Optional<UserEntity> findById(Long userId);

  Optional<UserEntity> findByEmailId(String email);

}
