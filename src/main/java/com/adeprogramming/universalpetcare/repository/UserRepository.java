package com.adeprogramming.universalpetcare.repository;

import com.adeprogramming.universalpetcare.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    boolean existsByEmail(String email);

    User save(User user);


    Optional<Object> findById(Long userId);

    void delete(Object o);

    List<User> findAll();
}
