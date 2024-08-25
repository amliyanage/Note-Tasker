package com.example.notetaker.Controller;

import com.example.notetaker.Bo.NoteBo;
import com.example.notetaker.Dto.Note;
import com.example.notetaker.Utill.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
 @RequiredArgsConstructor
public class NoteController {

    private NoteBo noteBo;
    //ToDo: CRUD of the Note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody Note noteDTO) {
        //ToDo: Handle with Bo
        noteDTO.setNoteId(AppUtil.createNoteId());
        System.out.println(noteDTO);
        return ResponseEntity.ok("Note Created Successfully");
    }

    @GetMapping(value ="allNotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Note> getAllNotes() {
        return null;
    }

    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Note getNote(@PathVariable("noteId") String noteId) {
        System.out.println(noteId);
        return new Note(
                "NOTE : 1",
                "This is the first note",
                "Hello Spring : This is a note",
                "L - 02",
                "2021-09-01"
        );
    }

    @PatchMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable ("noteId") String noteId, @RequestBody Note noteDTO) {
        System.out.println(noteId);
        System.out.println(noteDTO);
    }

    @DeleteMapping(value = "/{noteId}")
    public void deleteNote(@PathVariable ("noteId") String noteId) {
        System.out.println(noteId + " Deleted");
}
}