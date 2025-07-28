package com.esmay.software.controller;


import com.esmay.software.mapper.UserMapper;
import com.esmay.software.model.Designation;
import com.esmay.software.model.User;
import com.esmay.software.service.UserService;
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



    /*
       Dummy check authentication and authorization
     */

    @GetMapping("/software")
    public ResponseEntity<?>softwareEndPoint(){
        return ResponseEntity.ok("Hi, Software Engineer");
    }

    @GetMapping("/srsoftware")
    public ResponseEntity<?>srSoftwareEndPoint(){
        return ResponseEntity.ok("Hi, Sr. Software Engineer");
    }

    @GetMapping("/lead")
    public ResponseEntity<?>leadSoftwareEndPoint(){
        return ResponseEntity.ok("Hi, Lead Software Engineer");
    }

    @GetMapping("/manager")
    public ResponseEntity<?>managerEndPoint(){
        return ResponseEntity.ok("Hi, manager");
    }

}
