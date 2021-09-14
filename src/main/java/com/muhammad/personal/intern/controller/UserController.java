package com.muhammad.personal.intern.controller;

import com.muhammad.personal.intern.exceptions.*;
import com.muhammad.personal.intern.model.Response;
import com.muhammad.personal.intern.model.User;
import com.muhammad.personal.intern.model.dto.requests.RegisterUserDto;
import com.muhammad.personal.intern.model.dto.requests.UserLoginDTO;
import com.muhammad.personal.intern.repository.UserRepository;
import com.muhammad.personal.intern.security.jwt.JWTFilter;
import com.muhammad.personal.intern.security.jwt.JWTProvider;
import com.muhammad.personal.intern.service.interfaces.IAuthServices;
import com.muhammad.personal.intern.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private JWTProvider provider;
    @Autowired
    private JWTFilter filter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IAuthServices authServices;

    @GetMapping(path = "/lists", consumes = "application/json", produces = "application/json")
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    @GetMapping(path = "/getUserById/{id}", consumes = "application/json", produces = "application/json")
    public User getUserById(@PathVariable("id") long id){
        return userRepository.findById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addAdmin(@RequestBody RegisterUserDto userDto){
        Response response = new Response();
        try {
            if(userService.addUser(userDto)){
                response.setStatus("00");
                response.setMessage(userDto.getEmail() + " added Successfully");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (DataAlreadyExists | InvalidLoginException exception) {
            response.setStatus("400");
            response.setMessage(exception.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") long id){
        Response response = new Response();
        User u = userRepository.findById(id);
        userRepository.delete(u);
        response.setStatus("00");
        response.setMessage("delete Successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    ResponseEntity<Object> userLogin(@RequestBody UserLoginDTO loginDTO, HttpServletResponse res){
        Response response = new Response();
        try {
            User user = authServices.login(loginDTO);
            if(user != null){
                String token = provider.generateToken(loginDTO.getEmail());
                res.addHeader("AUTHORIZATION", "Bearer " + token);
                response.setStatus("00");
                response.setMessage(token);
                return ResponseEntity.status(HttpStatus.OK).body(response);            }
        } catch (UnauthorizedException e) {
            response.setStatus(String.valueOf(HttpStatus.UNAUTHORIZED));
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } catch (NotFoundException e) {
            response.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


}
