package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dto.UserDto;

import java.util.List;

public interface UserServiceBo {
    String saveUser(UserDto userDto) ;
    boolean updateUser(UserDto userDto);
    boolean deleteUser(String id);
    UserDto getUser(String id);
    List<UserDto> getAllUsers();
}
