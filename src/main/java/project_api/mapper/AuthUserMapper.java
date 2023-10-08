package project_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import project_api.config.securiy.AuthUser;
import project_api.model.UserModel;

@Mapper
public interface AuthUserMapper {
    AuthUserMapper INSTANCE = Mappers.getMapper(AuthUserMapper.class);
    @Mapping(target = "username",source = "username")
    AuthUser toAuthUser(UserModel user);
    @Mapping(target = "username",source = "username")
    UserModel toUser(AuthUser authUser);

}
