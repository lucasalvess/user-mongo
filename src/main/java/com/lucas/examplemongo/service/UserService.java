package com.lucas.examplemongo.service;

import com.lucas.examplemongo.dto.UserDTO;
import com.lucas.examplemongo.model.User;
import com.lucas.examplemongo.repository.UserRepository;
import com.lucas.examplemongo.resource.form.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDTO createUser(UserForm form){
        User user = repository.save(form.toUser());

        return new UserDTO(user);
    }

    public List<UserDTO> findAll(){
        List<User> users = repository.findAll();
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();

        for (User user: users) {
            userDTOS.add(new UserDTO(user));
        }

        return userDTOS;
    }
}
