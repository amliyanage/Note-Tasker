package lk.ijse.notetaker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "notes")
@Entity
public class NoteEntity {

    @Id
    private String NoteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String createDate;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

}
