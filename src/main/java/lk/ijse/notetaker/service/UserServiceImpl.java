package lk.ijse.notetaker.service;

import lk.ijse.notetaker.customObj.UserErrorResponse;
import lk.ijse.notetaker.customObj.UserResponse;
import lk.ijse.notetaker.dto.impl.UserDTO;
import lk.ijse.notetaker.entity.UserEntity;
import lk.ijse.notetaker.exception.DataPersistFailedException;
import lk.ijse.notetaker.exception.UserNotFoundException;
import lk.ijse.notetaker.repository.UserRepository;
import lk.ijse.notetaker.util.AppUtil;
import lk.ijse.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Mapping mapping;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Mapping mapping) {
        this.userRepository = userRepository;
        this.mapping = mapping;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserId());
        UserEntity savedUser = userRepository.save(mapping.convertToUserEntity(userDTO));
        if (savedUser == null && savedUser.getUserId() == null) {
            throw new DataPersistFailedException("User not saved");
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userRepository.findById(userDTO.getUserId());
        if (!tmpUser.isPresent()) throw new UserNotFoundException("User not found");
        else {
            UserEntity userEntity = tmpUser.get();
            userEntity.setFirstName(userDTO.getFirstName());
            userEntity.setLastName(userDTO.getLastName());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setPassword(userDTO.getPassword());
            userEntity.setProfilePic(userDTO.getProfilePic());
            // bcz of the @Transactional annotation, we don't need to call the save method
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> selectedUser = userRepository.findById(userId);
        if (!selectedUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        } else userRepository.deleteById(userId);
    }

    @Override
    public UserResponse getSelectedUser(String userId) {
        // using the custom method getUserEntitiesByUserId from the UserRepository
        return (userRepository.existsById(userId))
                ? mapping.convertToUserDTO(userRepository.getUserEntityByUserId(userId))
                : new UserErrorResponse(0, "User not found");
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapping.convertToUserDTO(userRepository.findAll());
    }
}
