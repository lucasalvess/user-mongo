package com.lucas.examplemongo.service;

import com.lucas.examplemongo.dto.UserDTO;
import com.lucas.examplemongo.model.User;
import com.lucas.examplemongo.repository.UserRepository;
import com.lucas.examplemongo.resource.form.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void remove(String id){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not founded");

        repository.delete(user.get());
    }
}
