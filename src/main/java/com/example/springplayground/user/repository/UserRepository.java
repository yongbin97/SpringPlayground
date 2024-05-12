package com.example.springplayground.user.repository;

import com.example.springplayground.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsUserById(Long userId);
}