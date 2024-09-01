package lk.ijse.notetaker.dto;

import jakarta.persistence.Column;
import lk.ijse.notetaker.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePic;
    private String password;
    private List<NoteDTO> notes;
}
