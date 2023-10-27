package com.user.service;

import com.user.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

   List<User> getAllUsers();

   User getUser(String id);

   void deleteUser(String id);

}
