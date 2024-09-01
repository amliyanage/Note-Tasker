package lk.ijse.notetaker.entity;

import jakarta.persistence.*;
import lk.ijse.notetaker.dto.NoteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity implements SuperEntity {

    @Id
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<NoteEntity> notes;
}
