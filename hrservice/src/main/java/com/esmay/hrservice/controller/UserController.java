package com.esmay.hrservice.controller;


import com.esmay.hrservice.mapper.UserMapper;
import com.esmay.hrservice.model.Designation;
import com.esmay.hrservice.model.User;
import com.esmay.hrservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    private final UserMapper userMapper;

    public UserController(
            UserMapper userMapper
    ){
        this.userMapper = userMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<?>registrationUser(@RequestBody User user){
        if(userService.saveUser(user) == null){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(userMapper.userToUserDTO(user).toString()
                            +"Email is already exist or invalid information");
        }

        return ResponseEntity.ok(userMapper.userToUserDTO(user));
    }

    @PostMapping("/add")
    public ResponseEntity<?>addDesignation(@RequestBody Designation designation){
        if(userService.saveDesignation(designation) == null){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Invalid designation");
        }
        return ResponseEntity.ok(designation.toString()+" is added");
    }





}
