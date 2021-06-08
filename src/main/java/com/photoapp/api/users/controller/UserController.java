package com.photoapp.api.users.controller;

import com.photoapp.api.users.dto.UserDto;
import com.photoapp.api.users.model.CreateUserRequestModel;
import com.photoapp.api.users.model.CreateUserResponseModel;
import com.photoapp.api.users.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Environment environment;
    private final UsersService usersService;
    private final ModelMapper mapper;

    @Autowired
    public UserController(
            Environment environment,
            UsersService usersService,
            ModelMapper mapper
    ) {
        this.environment = environment;
        this.usersService = usersService;
        this.mapper = mapper;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Working on the port: " + environment.getProperty("local.server.port");
    }

    @PostMapping(
            consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel model) {

        UserDto dto = mapper.map(model, UserDto.class);

        UserDto user = usersService.createUser(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.map(user, CreateUserResponseModel.class));
    }
}
