package com.esmay.software.service;

import com.esmay.software.dto.UserDTO;
import com.esmay.software.model.Designation;
import com.esmay.software.model.User;

public interface UserService {
    public UserDTO saveUser(User user);
    public UserDTO findByEmail(String email);
    public Designation saveDesignation(Designation designation);

}
