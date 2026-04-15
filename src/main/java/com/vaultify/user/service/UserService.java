package com.vaultify.user.service;

import com.vaultify.user.dto.UserRegistrationRequest;
import com.vaultify.user.dto.UserResponse;

public interface UserService {

    String register(UserRegistrationRequest request);
    String login(UserResponse request);
}
