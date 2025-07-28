package com.esmay.hrservice.service;

import com.esmay.hrservice.dto.UserDTO;
import com.esmay.hrservice.model.Designation;
import com.esmay.hrservice.model.User;

public interface UserService {
    public UserDTO saveUser(User user);
    public UserDTO findByEmail(String email);
    public Designation saveDesignation(Designation designation);

}
