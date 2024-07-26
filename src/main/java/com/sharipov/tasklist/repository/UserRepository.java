package com.sharipov.tasklist.repository;

import com.sharipov.tasklist.domain.user.Role;
import com.sharipov.tasklist.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

    Optional<User> findByUserName(String username);

    void create(User user);

    void update(User user);

    void insertUserRole(Long userId, Role role);

    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long id);

}
