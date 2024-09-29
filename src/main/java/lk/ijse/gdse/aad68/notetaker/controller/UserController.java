package lk.ijse.gdse.aad68.notetaker.controller;

import lk.ijse.gdse.aad68.notetaker.customObj.UserResponse;
import lk.ijse.gdse.aad68.notetaker.dto.impl.UserDto;
import lk.ijse.gdse.aad68.notetaker.exception.DataPersistFailedException;
import lk.ijse.gdse.aad68.notetaker.exception.UserNotFoundException;
import lk.ijse.gdse.aad68.notetaker.service.UserService;
import lk.ijse.gdse.aad68.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

//    @GetMapping("/healthcheck")
//    public String healthCheck(){
//        return "User Controller running!";
//    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveUser(@RequestPart("firstName") String firstName,
                                           @RequestPart("lastName") String lastName,
                                           @RequestPart("email") String email,
                                           @RequestPart("password") String password,
                                           @RequestPart("profilePic") MultipartFile profilePic){

        try{
        //Handle profile pic
            byte[] imageByteCollection = profilePic.getBytes();
            String base64ProfilePic = AppUtil.toBase64ProfilePic(imageByteCollection);
            var buildUserDto = new UserDto();
            buildUserDto.setFirstName(firstName);
            buildUserDto.setLastName(lastName);
            buildUserDto.setEmail(email);
            buildUserDto.setPassword(password);
            buildUserDto.setProfilePic(base64ProfilePic);

            userService.saveUser(buildUserDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable ("userId") String userId){
        try{
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getSelectedUser(@PathVariable ("userId") String userId){
        return userService.getSelectedUser(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PatchMapping(value = "/{userId}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable ("userId") String userId,
                                             @RequestPart("firstName") String updateFirstName,
                                             @RequestPart("lastName") String updateLastName,
                                             @RequestPart("email") String updateEmail,
                                             @RequestPart("password") String updatePassword,
                                             @RequestPart("profilePic") MultipartFile updateProfilePic
                                             ){

        try {
            byte[] updateImageByteCollection = updateProfilePic.getBytes();
            String updateBase64ProfilePic = AppUtil.toBase64ProfilePic(updateImageByteCollection);
            var updateUser = new UserDto();
            updateUser.setUserId(userId);
            updateUser.setEmail(updateEmail);
            updateUser.setFirstName(updateFirstName);
            updateUser.setLastName(updateLastName);
            updateUser.setPassword(updatePassword);
            updateUser.setProfilePic(updateBase64ProfilePic);

            userService.updateUser(updateUser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
