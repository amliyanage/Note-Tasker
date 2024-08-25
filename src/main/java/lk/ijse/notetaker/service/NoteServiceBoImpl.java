package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
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
        noteDto.setId(AppUtil.createNoteId());
        saveNotes.add(noteDto);
        return "Note Saved Successfully";
    }

    @Override
    public boolean updateNote(String id ,NoteDTO noteDto) {
        ListIterator<NoteDTO> noteDTOListIterator = saveNotes.listIterator();
        while (noteDTOListIterator.hasNext()) {
            NoteDTO noteDTO = noteDTOListIterator.next();
            if (noteDTO.getId().equals(id)) {
                noteDTOListIterator.set(noteDto);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteNote(String id) {
        for (NoteDTO noteDTO : saveNotes) {
            if (noteDTO.getId().equals(id)) {
                saveNotes.remove(noteDTO);
                return true;
            }
        }
        return false;
    }

    @Override
    public NoteDTO getNote(String id) {
        for (NoteDTO noteDTO : saveNotes) {
            if (noteDTO.getId().equals(id)) {
                return noteDTO;
            }
        }
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return saveNotes;
    }
}
