package lk.ijse.notetaker.service;

import lk.ijse.notetaker.dao.NoteDao;
import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.entity.NoteEntity;
import lk.ijse.notetaker.util.AppUtil;
import lk.ijse.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class NoteServiceBoImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private Mapping mapping;

    @Override
    public String saveNote(NoteDTO noteDto) {
        noteDao.save(mapping.convertToNoteEntity(noteDto));
        return "NoteDTO Saved Successfully in BO layer";
    }

    @Override
    public boolean updateNote(String id ,NoteDTO noteDto) {
        noteDao.save(mapping.convertToNoteEntity(noteDto));
        return true;
    }

    @Override
    public boolean deleteNote(String id) {
        if (noteDao.existsById(id)){
            noteDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public NoteDTO getNote(String id) {
        return mapping.convertToNoteDTO(noteDao.findById(id).get());
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        List<NoteEntity> all = noteDao.findAll();
        return mapping.convertToNoteDTOList(all);
    }
}
