package com.muhammad.personal.intern.service.implementation;

import com.muhammad.personal.intern.exceptions.NotFoundException;
import com.muhammad.personal.intern.exceptions.UnauthorizedException;
import com.muhammad.personal.intern.model.User;
import com.muhammad.personal.intern.model.dto.requests.UserLoginDTO;
import com.muhammad.personal.intern.repository.UserRepository;
import com.muhammad.personal.intern.service.interfaces.IAuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServicesImplementation implements IAuthServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public User login(UserLoginDTO userLogin) throws UnauthorizedException{
        User user = userRepository.findByEmail(userLogin.getEmail()).get();
        if(!(encoder.matches(userLogin.getPassword(),user.getPassword()))){
               throw new UnauthorizedException("Invalid password");
        }
        return user;
    }
}
