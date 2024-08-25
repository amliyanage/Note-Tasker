package lk.ijse.notetaker.util;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.entity.NoteEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    private ModelMapper modelMapper;

    //matters of NodeEntity and NoteDTO
    public NoteDTO convertToNoteDTO(NoteEntity noteEntity){
        return modelMapper.map(noteEntity, NoteDTO.class);
    }

    //matters of NoteDTO and NoteEntity
    public NoteEntity convertToNoteEntity(NoteDTO noteDTO){
        return modelMapper.map(noteDTO, NoteEntity.class);
    }

    //matters of List<NoteEntity> and List<NoteDTO>
    public List<NoteDTO> convertToNoteDTOList(List<NoteEntity> noteEntities){
        return modelMapper.map(noteEntities, List.class);
    }
}
