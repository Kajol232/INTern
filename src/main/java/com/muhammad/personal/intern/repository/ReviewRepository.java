package com.muhammad.personal.intern.repository;

import com.muhammad.personal.intern.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> getAllByCompany(long id);
    List<Review> getAllByStudent(long id);
    int countAllByCompanyIsLike(long id);
    int countAllByStudentIsLike(long id);

}
