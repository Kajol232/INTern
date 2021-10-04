package com.muhammad.personal.intern.service.implementation;

import com.muhammad.personal.intern.exceptions.DataAlreadyExists;
import com.muhammad.personal.intern.exceptions.InvalidLoginException;
import com.muhammad.personal.intern.model.Student;
import com.muhammad.personal.intern.model.dto.requests.AddStudentDto;
import com.muhammad.personal.intern.model.enums.Degree;
import com.muhammad.personal.intern.repository.StudentRepository;
import com.muhammad.personal.intern.service.interfaces.IStudentServices;
import com.muhammad.personal.intern.utils.IUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServicesImpl implements IStudentServices {
    @Autowired
    private IUtilityService util;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public boolean addStudent(AddStudentDto studentDto) throws Exception {
        if(studentRepository.existsByEmail(studentDto.getEmail())){
            throw new DataAlreadyExists(studentDto.getEmail() + " already exists");
        }
        if(!studentDto.getEmail().contains("@") || !studentDto.getEmail().contains(".")){
            throw new InvalidLoginException("Invalid Email");
        }
        if(util.dobConversion(studentDto.getDob()) < 18){
            throw new Exception("Student must be at least 18yrs of age");
        }

        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setDob(studentDto.getDob());
        student.setGender(studentDto.getGender());
        student.setMobile(studentDto.getMobile());
        student.setInstitution((studentDto.getInstitution()));
        student.setDegree(studentDto.getDegree());


        return false;
    }
}
