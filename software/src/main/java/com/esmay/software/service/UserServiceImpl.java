package com.esmay.software.service;


import com.esmay.software.dto.UserDTO;
import com.esmay.software.mapper.UserMapper;
import com.esmay.software.model.Designation;
import com.esmay.software.model.User;
import com.esmay.software.repository.DesignationRepo;
import com.esmay.software.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final DesignationRepo designationRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
            UserRepo userRepo,
            DesignationRepo designationRepo,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepo = userRepo;
        this.designationRepo = designationRepo;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO saveUser(User user) {
        Optional<User> optionalUser = userRepo.findByEmail(user.getEmail());
        Optional<Designation>optionalDesignation = designationRepo.findById(user.getDesignation().getId());
        if(
                optionalDesignation.isEmpty()
                || optionalUser.isPresent()
        ) return null;
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.userToUserDTO(userRepo.save(user));
    }

    @Override
    public Designation saveDesignation(Designation designation) {
        Optional<Designation>optionalDesig = designationRepo.findByName(designation.getName().toLowerCase());
        if(optionalDesig.isPresent()){
            return null;
        }
        designation.setName(designation.getName().toLowerCase());
        return designationRepo.save(designation);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userMapper.userToUserDTO(userRepo.findByEmail(email).get());
    }
}
