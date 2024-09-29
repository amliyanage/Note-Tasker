package lk.ijse.gdse.aad68.notetaker.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteErrorResponse implements NoteResponse{
    private int errorCode;
    private String errorMessage;
}
