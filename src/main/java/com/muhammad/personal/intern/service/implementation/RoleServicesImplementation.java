package com.muhammad.personal.intern.service.implementation;

import com.muhammad.personal.intern.exceptions.DataAlreadyExists;
import com.muhammad.personal.intern.model.Role;
import com.muhammad.personal.intern.repository.RoleRepository;
import com.muhammad.personal.intern.service.interfaces.IRoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServicesImplementation implements IRoleServices {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public boolean addRole(Role role) throws DataAlreadyExists {
        if(roleRepository.findByName(role.getName()) != null){
            throw new DataAlreadyExists("Role already exists with");
        }
        roleRepository.save(role);
        return true;
    }
}
