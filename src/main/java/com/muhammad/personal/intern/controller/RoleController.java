package com.muhammad.personal.intern.controller;

import com.muhammad.personal.intern.exceptions.DataAlreadyExists;
import com.muhammad.personal.intern.model.Response;
import com.muhammad.personal.intern.model.Role;
import com.muhammad.personal.intern.repository.RoleRepository;
import com.muhammad.personal.intern.service.interfaces.IRoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    IRoleServices roleServices;
    private Response response = new Response();
    @GetMapping(path = "/lists",produces = "application/json")
    public List<Role> roles(){
        return (List) roleRepository.findAll();
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createRole(@RequestParam("name") String name){
        Role role = new Role(name);
        try {
            roleServices.addRole(role);
            response.setStatus("00");
            response.setMessage("Role created successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (DataAlreadyExists d) {
            response.setStatus("400");
            response.setMessage(d.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable("id") long id){
        Role role = roleRepository.findById(id).get();
        roleRepository.delete(role);
        response.setStatus("00");
        response.setMessage("Role deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping(path = "/getRoleById/{id}")
    public Role getRoleById(@PathVariable("id") long id){
        return roleRepository.findById(id).get();
    }
}
