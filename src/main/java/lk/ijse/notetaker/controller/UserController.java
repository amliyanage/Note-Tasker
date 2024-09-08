package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.dto.UserDto;
import lk.ijse.notetaker.service.UserServiceBo;
import lk.ijse.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("health")
    public String healthCheck(){
        return "User Controller is OK";
    }

    @Autowired
    private final UserServiceBo userServiceBo;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePic") String profilePic

    ){
        var base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
        var buildUserDto = new UserDto();
        buildUserDto.setFirstName(firstName);
        buildUserDto.setLastName(lastName);
        buildUserDto.setEmail(email);
        buildUserDto.setPassword(password);
        buildUserDto.setProfilePic(base64ProfilePic);

        // send to the service layer
        return new ResponseEntity<>(userServiceBo.saveUser(buildUserDto), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable ("userId") String userId){
        return ResponseEntity.ok(userServiceBo.getUser(userId));
    }

    @GetMapping(value = "/allUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userServiceBo.getAllUsers());
    }

    @DeleteMapping({"/{userId}"})
    public ResponseEntity<String> deleteUser( @PathVariable("userId") String userId ){
        return new ResponseEntity<>(
                userServiceBo.deleteUser(userId) ? "User Deleted Successfully" : "User Delete Failed"
                , HttpStatus.OK);
    }

    @PatchMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto buildUserDto){
        return new ResponseEntity<>(
                userServiceBo.updateUser(userId,buildUserDto)
                        ? "User Updated Successfully"
                        : "User Update Failed",HttpStatus.OK);
    }

}
