package project_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import project_api.dto.UserDto;
import project_api.model.UserModel;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(UserModel model);
    UserModel toModel(UserDto dto);
    

}
