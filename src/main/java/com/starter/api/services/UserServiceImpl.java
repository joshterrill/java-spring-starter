package com.starter.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.starter.api.models.User;
import com.starter.api.repositories.UserRepository;
import com.starter.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUserId(Long userId) {
        Optional<User> foundUser = userRepository.findById(userId);
        return foundUser;
    }
}