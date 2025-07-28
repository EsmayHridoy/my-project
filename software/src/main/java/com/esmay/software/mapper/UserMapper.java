package com.esmay.software.mapper;
import com.esmay.software.dto.UserDTO;
import com.esmay.software.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDtoToUser(UserDTO userDTO);
}
