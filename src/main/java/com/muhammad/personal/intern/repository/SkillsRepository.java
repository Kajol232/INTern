package com.muhammad.personal.intern.repository;

import com.muhammad.personal.intern.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skill, Long> {
    boolean existsByName(String name);
}
