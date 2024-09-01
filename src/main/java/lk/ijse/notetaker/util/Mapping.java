package lk.ijse.notetaker.util;

import lk.ijse.notetaker.dto.NoteDTO;
import lk.ijse.notetaker.dto.UserDto;
import lk.ijse.notetaker.entity.NoteEntity;
import lk.ijse.notetaker.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Mapping {

    @Autowired
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

    public UserDto convertToUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDto.class);
    }

    public UserEntity convertToUserEntity(UserDto userDto){
        return modelMapper.map(userDto, UserEntity.class);
    }

    public List<UserDto> convertToUserDTOList(List<UserEntity> userEntities){
        return modelMapper.map(userEntities, List.class);
    }
}
