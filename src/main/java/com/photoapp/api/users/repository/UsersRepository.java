package com.photoapp.api.users.repository;

import com.photoapp.api.users.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
}
