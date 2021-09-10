package com.muhammad.personal.intern.repository;

import com.muhammad.personal.intern.model.Application;
import com.muhammad.personal.intern.model.enums.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
    List<Application> getAllByApplicant(long studentId);
    List<Application> getAllByApplicantAndApplicationStatus(long studentId, Status status);
}
