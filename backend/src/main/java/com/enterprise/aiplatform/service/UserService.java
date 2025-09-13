package com.enterprise.aiplatform.service;

import com.enterprise.aiplatform.controller.AuthController.RegisterRequest;
import com.enterprise.aiplatform.model.User;

public interface UserService {
    User createUser(RegisterRequest registerRequest);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}