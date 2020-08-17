package com.lucas.examplemongo.service;

import com.lucas.examplemongo.dto.UserDTO;
import com.lucas.examplemongo.model.User;
import com.lucas.examplemongo.repository.UserRepository;
import com.lucas.examplemongo.resource.form.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @CacheEvict(cacheNames = "User", allEntries = true)
    public UserDTO createUser(UserForm form){
        User user = repository.save(form.toUser());

        return save(user);
    }

    @Cacheable(cacheNames = "User", key="#root.method.name")
    public List<UserDTO> findAll(){
        List<User> users = repository.findAll();
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();

        for (User user: users) {
            userDTOS.add(new UserDTO(user));
        }

        return userDTOS;
    }

    @Cacheable(cacheNames = "User", key = "#id")
    public UserDTO findById(String id){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not founded");

        return new UserDTO(user.get());
    }

    @CacheEvict(cacheNames = "User", key = "#id")
    public void remove(String id){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not founded");

        repository.delete(user.get());
    }

    @CachePut(cacheNames = "User", key = "#id")
    public UserDTO update(UserForm userForm, String id){
        Optional<User> user = repository.findById(id);

        User existentUser = user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not founded"));

        BeanUtils.copyProperties(userForm,existentUser);
        repository.save(existentUser);

        return save(existentUser);
    }

    private UserDTO save(User user){
        try {
            return new UserDTO(repository.save(user));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cant save user",e);
        }
    }
}
