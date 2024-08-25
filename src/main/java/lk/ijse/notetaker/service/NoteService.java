package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dto.NoteDTO;

import java.util.List;

public interface NoteService {
    String saveNote(NoteDTO noteDto);
    boolean updateNote(String id ,NoteDTO noteDto);
    boolean deleteNote(String id);
    NoteDTO getNote(String id);
    List<NoteDTO> getAllNotes();
}
