package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dao.UserDao;
import lk.ijse.notetaker.dto.UserDto;
import lk.ijse.notetaker.util.AppUtil;
import lk.ijse.notetaker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceBoImpl implements UserServiceBo {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public String saveUser(UserDto userDto) {
        userDto.setUserId(AppUtil.createUserId());
        userDao.save(mapping.convertToUserEntity(userDto));
        return "User Saved Successfully";
    }

    @Override
    public boolean updateUser(String id, UserDto userDto) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    @Override
    public UserDto getUser(String id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }
}
