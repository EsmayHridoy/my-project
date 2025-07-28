package com.esmay.hrservice.mapper;
import com.esmay.hrservice.dto.UserDTO;
import com.esmay.hrservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDtoToUser(UserDTO userDTO);
}
