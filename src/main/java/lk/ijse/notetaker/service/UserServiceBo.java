package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dto.UserDto;

import java.util.List;

public interface UserServiceBo {
    String saveUser(UserDto userDto) ;
    boolean updateUser(String id, UserDto userDto);
    boolean deleteUser(String id);
    UserDto getUser(String id);
    List<UserDto> getAllUsers();
}
