package com.muhammad.personal.intern.repository;

import com.muhammad.personal.intern.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    User findById(long id);
    User findByEmail(long id);
}
