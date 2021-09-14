package com.muhammad.personal.intern.repository;

import com.muhammad.personal.intern.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findStudentsByEmail(String email);
    boolean existsByEmail(String email);


}
