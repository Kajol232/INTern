package com.muhammad.personal.intern.service.interfaces;

import com.muhammad.personal.intern.exceptions.DataAlreadyExists;
import com.muhammad.personal.intern.model.Role;

public interface IRoleServices {
    boolean addRole(Role role) throws DataAlreadyExists;

}
