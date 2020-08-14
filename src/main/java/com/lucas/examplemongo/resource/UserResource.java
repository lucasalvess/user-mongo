package com.lucas.examplemongo.resource;

import com.lucas.examplemongo.dto.UserDTO;
import com.lucas.examplemongo.resource.form.UserForm;
import com.lucas.examplemongo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "user",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping
    public List<UserDTO> findAllUsers(){
        return service.findAll();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserForm userForm){
        return service.createUser(userForm);
    }

    @DeleteMapping
    public void removeUser(@RequestParam String id){
        service.remove(id);
    }
}
