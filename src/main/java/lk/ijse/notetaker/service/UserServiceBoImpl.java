package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dao.UserDao;
import lk.ijse.notetaker.dto.UserDto;
import lk.ijse.notetaker.entity.UserEntity;
import lk.ijse.notetaker.util.AppUtil;
import lk.ijse.notetaker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<UserEntity> tempUserEntity = userDao.findById(id);
        if (tempUserEntity.isEmpty()){
            return false;
        }
        else {
            tempUserEntity.get().setFirstName(userDto.getFirstName());
            tempUserEntity.get().setLastName(userDto.getLastName());
            tempUserEntity.get().setEmail(userDto.getEmail());
            tempUserEntity.get().setPassword(userDto.getPassword());
            tempUserEntity.get().setProfilePic(userDto.getProfilePic());
        }
        return true;
    }

    @Override
    public boolean deleteUser(String id) {
        if (userDao.existsById(id)){
            userDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserDto getUser(String id) {
        UserEntity entity = userDao.getUserEntityByUserId(id);
        return mapping.convertToUserDTO(entity);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntityList = userDao.findAll();
        return mapping.convertToUserDTOList(userEntityList);
    }
}
