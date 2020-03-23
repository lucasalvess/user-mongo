package com.lucas.examplemongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucas.examplemongo.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
