package com.muhammad.personal.intern.service.implementation;

import com.muhammad.personal.intern.exceptions.InvalidLoginException;
import com.muhammad.personal.intern.exceptions.UnknownUserException;
import com.muhammad.personal.intern.exceptions.DataAlreadyExists;
import com.muhammad.personal.intern.model.*;
import com.muhammad.personal.intern.model.dto.requests.RegisterUserDto;
import com.muhammad.personal.intern.model.dto.requests.UpdatePasswordDto;
import com.muhammad.personal.intern.repository.RoleRepository;
import com.muhammad.personal.intern.repository.UserRepository;
import com.muhammad.personal.intern.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImplementation implements IUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(!optionalUser.isPresent()){
            throw new UsernameNotFoundException(email + "not found");

        }
        User user = optionalUser.get();
        List<String> roleLists = new ArrayList<>();
        for(Role role : user.getRoles()){
            roleLists.add(role.getName());
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .accountExpired(!user.isActive())
                .roles(roleLists.toArray(new String[0]))
                .build();
    }

    @Override//default pass 4 admins is pass@word
    public boolean addUser(RegisterUserDto userDto) throws DataAlreadyExists, InvalidLoginException {
        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new DataAlreadyExists(userDto.getEmail() + " already exists");
        }
        if(!userDto.getEmail().contains("@") || !userDto.getEmail().contains(".")){
            throw new InvalidLoginException("Invalid Email");
        }
        if(userDto.getPassword().isEmpty() || userDto.getPassword().isBlank() || userDto.getEmail().isBlank()
                || userDto.getEmail().isEmpty()){
            throw new InvalidLoginException("Password cannot be blank");
        }
        if (!userDto.getConfirmPassword().equals(userDto.getPassword())){
            throw new InvalidLoginException("Password Not match");
        }

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setEmailNotification(userDto.isEmailNotification());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        List<Role> roleList = new ArrayList<>();
        String title = userDto.getTitle();
        roleList.add(getRole(title));
        user.setRoles(roleList);
        user.setActive(false);

        userRepository.save(user);
        return true;
    }

    @Override
    public boolean changePassword(UpdatePasswordDto passwordDto) throws InvalidLoginException {
        if(!passwordEncoder.matches(passwordDto.getOldPassword(),passwordDto.getUser().getPassword())){
            throw new InvalidLoginException("Incorrect Password, Please input a valid password");
        }
        passwordCheck(passwordDto);
        User user = passwordDto.getUser();
        user.setPassword(passwordEncoder.encode(passwordDto.getPassword()));
        userRepository.save(user);
        return true;

    }

    private void passwordCheck(UpdatePasswordDto passwordDto) throws InvalidLoginException {
        if(passwordDto.getPassword().isEmpty() || passwordDto.getPassword().isBlank()){
            throw new InvalidLoginException("Password cannot be blank");
        }
        if (!passwordDto.getConfirmPassword().equals(passwordDto.getPassword())){
            throw new InvalidLoginException("Password Not match");
        }

    }


    @Override
    public User updateUserDetails(User user, long id) throws UnknownUserException {
        User u = userRepository.findById(id);
        if(u == null){
            throw new UnknownUserException("User not found");
        }
        u.setEmail(user.getEmail());
        u.setUsername(user.getUsername());
        return u;
    }

    @Override
    public String getSignedUser(Authentication auth) {
        return null;
    }

    private Role getRole(String name){
        Optional<Role> optionalRole = roleRepository.findByName(name);
        return optionalRole.orElse(null);
    }

}
