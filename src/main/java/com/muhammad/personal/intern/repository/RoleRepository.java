package com.muhammad.personal.intern.repository;

import com.muhammad.personal.intern.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);

}
