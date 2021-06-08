package com.photoapp.api.users.service;

import com.photoapp.api.users.dto.UserDto;
import com.photoapp.api.users.entity.UserEntity;
import com.photoapp.api.users.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository repository;
    private final ModelMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(
            UsersRepository repository,
            ModelMapper mapper,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(UserDto dto) {

        dto.setUserId(UUID.randomUUID().toString());
        dto.setEncryptedPassword(passwordEncoder.encode(dto.getPassword()));

        UserEntity entity = mapper.map(dto, UserEntity.class);

        UserEntity userEntity = repository.save(entity);

        return mapper.map(userEntity, UserDto.class);
    }
}
