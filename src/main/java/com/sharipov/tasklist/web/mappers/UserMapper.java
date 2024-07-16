package com.sharipov.tasklist.web.mappers;



import com.sharipov.tasklist.domain.user.User;
import com.sharipov.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
