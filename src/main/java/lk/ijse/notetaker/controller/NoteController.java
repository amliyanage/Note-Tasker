package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.service.NoteService;
import lk.ijse.notetaker.util.AppUtil;
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

    @GetMapping("health")
    public String healthCheck() {
        return "Note Controller is OK";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO noteDTO) {
        noteDTO.setId(AppUtil.createNoteId());
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
        return noteBo.updateNote(noteId, noteDTO) ? ResponseEntity.ok("Note Updated Successfully")
                : new ResponseEntity<>("Note Update Failed", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {
        boolean isDeleted = noteBo.deleteNote(noteId);
        if (isDeleted){
            return ResponseEntity.ok("Note Deleted Successfully");
        }
        else {
            return  new ResponseEntity<>("Note Delete Failed", HttpStatus.BAD_REQUEST);
        }
    }
}
