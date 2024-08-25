package com.example.notetaker.Bo;


import com.example.notetaker.Dto.Note;

import java.util.List;

public final class NoteBoImpl implements NoteBo {
    @Override
    public String saveNote(Note noteDto) {
        return "";
    }

    @Override
    public boolean updateNote(String noteId, Note noteDto) {
        return false;
    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
    }

    @Override
    public Note getNote(String note) {
        return null;
    }

    @Override
    public List<Note> getAllNotes() {
        return List.of();
    }
}