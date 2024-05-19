package com.example.springplayground.user.implement;

import com.example.springplayground.user.entity.User;
import com.example.springplayground.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class UserReader {
    private final UserRepository userRepository;

    public User read(Long userId) {
        log.info("[INFO] UserReader - read");
        return userRepository.getUserById(userId);
    }
}
