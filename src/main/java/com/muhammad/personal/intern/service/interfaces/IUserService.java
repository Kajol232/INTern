package com.muhammad.personal.intern.service.interfaces;

import com.muhammad.personal.intern.exceptions.InvalidLoginException;
import com.muhammad.personal.intern.exceptions.UnknownUserException;
import com.muhammad.personal.intern.exceptions.DataAlreadyExists;
import com.muhammad.personal.intern.model.User;
import com.muhammad.personal.intern.model.dto.requests.RegisterUserDto;
import com.muhammad.personal.intern.model.dto.requests.UpdatePasswordDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUserService extends UserDetailsService {

    boolean addUser(RegisterUserDto userDto) throws DataAlreadyExists, InvalidLoginException;
    boolean changePassword(UpdatePasswordDto passwordDto) throws InvalidLoginException;
    User updateUserDetails(User user, long id) throws UnknownUserException;
    String getSignedUser(Authentication auth);


}
