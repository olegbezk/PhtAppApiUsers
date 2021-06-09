package com.photoapp.api.users.service;

import com.photoapp.api.users.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {

    UserDto createUser(UserDto dto);

    UserDto getUserDetailsByEmail(String email);
}
