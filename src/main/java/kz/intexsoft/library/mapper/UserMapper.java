package kz.intexsoft.library.mapper;

import kz.intexsoft.library.dto.UserDto;
import kz.intexsoft.library.entity.User;

public class UserMapper {
    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
