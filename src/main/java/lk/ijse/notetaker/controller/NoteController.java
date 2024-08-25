package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor

public class NoteController {
    @Autowired
    private final NoteService noteBo;

    //ToDo: CRUD of the Note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO noteDTO) {
        var isSaved = noteBo.saveNote(noteDTO);
        return ResponseEntity.ok(isSaved);
    }

    @GetMapping(value ="allNotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes() {
        return noteBo.getAllNotes();
    }

    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable("noteId") String noteId) {
        return noteBo.getNote(noteId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDTO noteDTO) {
        boolean isUpdated = noteBo.updateNote(noteId, noteDTO);
        if (isUpdated){
            return ResponseEntity.ok("Note Updated Successfully");
        }
        else {
            return ResponseEntity.ok("Note Update Failed");
        }
    }

    @DeleteMapping(value = "/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {
        boolean isDeleted = noteBo.deleteNote(noteId);
        if (isDeleted){
            return ResponseEntity.ok("Note Deleted Successfully");
        }
        else {
            return ResponseEntity.ok("Note Delete Failed");
        }
    }
}
