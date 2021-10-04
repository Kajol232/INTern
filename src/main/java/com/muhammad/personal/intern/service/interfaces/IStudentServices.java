package com.muhammad.personal.intern.service.interfaces;

import com.muhammad.personal.intern.model.dto.requests.AddStudentDto;

public interface IStudentServices {
    boolean addStudent(AddStudentDto studentDto) throws Exception;
}
