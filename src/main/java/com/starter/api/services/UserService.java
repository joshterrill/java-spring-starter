package com.starter.api.services;
import com.starter.api.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByUserId(Long userId);
}