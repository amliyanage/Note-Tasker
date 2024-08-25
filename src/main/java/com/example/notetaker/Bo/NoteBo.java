package com.example.notetaker.Bo;

import com.example.notetaker.Dto.Note;

import java.util.List;

public sealed interface NoteBo permits NoteBoImpl {
    String saveNote(Note noteDto);
    boolean updateNote(String noteId, Note noteDto);
    boolean deleteNote(String noteId);
    Note getNote(String note);
    List<Note> getAllNotes();
}
