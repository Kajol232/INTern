package com.muhammad.personal.intern.repository;

import com.muhammad.personal.intern.model.Job;
import com.muhammad.personal.intern.model.enums.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {
    List<Job> findAllByCompany(long companyId);
    List<Job> findAllBySkillSet(long skillId);
    List<Job> findAllByStatus(Status status);
    //find all open jobs

}
