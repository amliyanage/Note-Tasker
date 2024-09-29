package lk.ijse.gdse.aad68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad68.notetaker.customObj.UserErrorResponse;
import lk.ijse.gdse.aad68.notetaker.customObj.UserResponse;
import lk.ijse.gdse.aad68.notetaker.dao.UserDao;
import lk.ijse.gdse.aad68.notetaker.dto.impl.UserDto;
import lk.ijse.gdse.aad68.notetaker.entity.UserEntity;
import lk.ijse.gdse.aad68.notetaker.exception.DataPersistFailedException;
import lk.ijse.gdse.aad68.notetaker.exception.UserNotFoundException;
import lk.ijse.gdse.aad68.notetaker.util.AppUtil;
import lk.ijse.gdse.aad68.notetaker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private final Mapping mapping;
    @Override
    public void saveUser(UserDto userDto) {
        userDto.setUserId(AppUtil.createUserId());
        UserEntity savedUser = userDao.save(mapping.convertToEntity(userDto));
        if (savedUser == null && savedUser.getUserId() == null) {
            throw new DataPersistFailedException("Can't save the user!");
        }
    }

    @Override
    public void updateUser(UserDto userDto) {
        Optional<UserEntity> tmpUser = userDao.findById(userDto.getUserId());
        if (!tmpUser.isPresent()){
            throw new UserNotFoundException("User Not Found!");
        }else {
            tmpUser.get().setFirstName(userDto.getFirstName());
            tmpUser.get().setEmail(userDto.getEmail());
            tmpUser.get().setLastName(userDto.getLastName());
            tmpUser.get().setPassword(userDto.getPassword());
            tmpUser.get().setProfilePic(userDto.getProfilePic());
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional <UserEntity> selectedUser = userDao.findById(userId);

        if (!selectedUser.isPresent()){
            throw new UserNotFoundException("User Not Found!");
        }else {
            userDao.deleteById(userId);
        }
    }

    @Override
    public UserResponse getSelectedUser(String userId) {
        if (userDao.existsById(userId)){
            return mapping.convertToUserDTO(userDao.getUserEntityByUserId(userId));
        }else {
            return new UserErrorResponse(0, "User Not Found");
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        return mapping.convertToUserDTOS(userDao.findAll());
    }
}
