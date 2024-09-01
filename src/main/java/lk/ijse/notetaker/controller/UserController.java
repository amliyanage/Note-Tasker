package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.dto.UserDto;
import lk.ijse.notetaker.service.UserServiceBo;
import lk.ijse.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> createNote(@RequestBody UserDto userDto) {
//
//    }

}
