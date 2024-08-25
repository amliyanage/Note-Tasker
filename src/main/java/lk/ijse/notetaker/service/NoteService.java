package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dto.NoteDTO;

public interface NoteService {
    String saveNote(NoteDTO noteDto);
    boolean updateNote();
    boolean deleteNote();
    String getNote();
    String getAllNotes();
}
