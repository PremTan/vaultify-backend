package com.vaultify.user.service.impl;

import com.vaultify.common.enums.UserStatus;
import com.vaultify.user.dto.UserRegistrationRequest;
import com.vaultify.user.dto.UserResponse;
import com.vaultify.user.entity.UserMaster;
import com.vaultify.user.repository.UserRepository;
import com.vaultify.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public String register(UserRegistrationRequest request) {
        Optional<UserMaster> existingUser =
                userRepository.findByEmailOrMobile(request.getEmail(), request.getMobileNumber());

        if (existingUser.isPresent()) {
            return "User already exists!";
        }

        UserMaster user = new UserMaster();

        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());
        user.setPassword(request.getPassword());

        // Default status
        user.setStatus(UserStatus.INACTIVE);

        userRepository.save(user);
        return "User Registered Successfully";
    }

    @Override
    public String login(UserResponse request) {

        Optional<UserMaster> user =
                userRepository.findByEmailOrMobile(request.getEmail(), request.getMobileNumber());

        if (user.isEmpty()) {
            return "User not found!";
        }
        if (user.isEmpty()) {
            return "User not found!";
        }

        UserMaster loggedInUser = user.get();

        if (loggedInUser.getStatus() == UserStatus.BLOCKED) {
            return "User is BLOCKED!";
        }

        if (!loggedInUser.getPassword().equals(request.getPassword())) {
            return "Invalid Password!";
        }

        // ✅ ACTIVE on login
        loggedInUser.setStatus(UserStatus.ACTIVE);
        userRepository.save(loggedInUser);

        return "Login Successful";
    }
}
