package lk.ijse.gdse.aad68.notetaker.dao;

import lk.ijse.gdse.aad68.notetaker.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity, String> {
    @Query()
    NoteEntity getNoteEntitiesByNoteId(String noteId);
}
