package lk.ijse.gdse.aad68.notetaker.dto.impl;

import lk.ijse.gdse.aad68.notetaker.customObj.UserResponse;
import lk.ijse.gdse.aad68.notetaker.dto.SuperDto;
import lk.ijse.gdse.aad68.notetaker.dto.impl.NoteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto implements SuperDto, UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private List<NoteDTO> notes;
}
