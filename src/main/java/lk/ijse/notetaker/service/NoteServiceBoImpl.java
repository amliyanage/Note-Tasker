package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dto.NoteDTO;

import java.util.ArrayList;
import java.util.List;

public class NoteServiceBoImpl implements NoteService {

    List<NoteDTO> saveNotes = new ArrayList<>();

    public NoteServiceBoImpl() {
        saveNotes.add(new NoteDTO("1", "Note 1", "This is Note 1", "High", "2021-09-01"));
        saveNotes.add(new NoteDTO("2", "Note 2", "This is Note 2", "Medium", "2021-09-02"));
        saveNotes.add(new NoteDTO("3", "Note 3", "This is Note 3", "Low", "2021-09-03"));
        System.out.println(saveNotes);
    }

    @Override
    public String saveNote(NoteDTO noteDto) {
        saveNotes.add(noteDto);
        return "Note Saved";
    }

    @Override
    public boolean updateNote() {
        return false;
    }

    @Override
    public boolean deleteNote() {
        return false;
    }

    @Override
    public String getNote() {
        return null;
    }

    @Override
    public String getAllNotes() {
        return null;
    }
}
