package com.example.store.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.store.user.dto.UserResponse;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponse> getUsers() {
        logger.info("Getting all users");

        List<User> users = userRepository.findAll();
        List<UserResponse> responses = users.stream().map(userMapper::toResponse).toList();

        logger.info("Found {} users", users.size());
        return responses;
    }
}
