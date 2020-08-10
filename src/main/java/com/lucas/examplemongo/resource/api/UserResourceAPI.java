package com.lucas.examplemongo.resource.api;

import com.lucas.examplemongo.dto.UserDTO;
import com.lucas.examplemongo.resource.form.UserForm;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserResourceAPI {

    @ApiOperation(value = "List all users")
    @ApiResponse(code = 200, message = "Ok", response = UserDTO.class)
    List<UserDTO> findAllUsers();

    @ApiOperation(value = "Create a new user")
    @ApiResponse(code = 201, message = "Ok", response = SecurityProperties.User.class)
    UserDTO createUser(@RequestBody UserForm userForm);
}
