package com.example.store.user;

import org.springframework.stereotype.Component;

import com.example.store.user.dto.UserResponse;

@Component
public class UserMapper {
    public UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getUsername());
    }
}
