package project_api.service;

import java.util.List;

import project_api.dto.UserDto;
import project_api.model.UserModel;

public interface UserService {
    UserModel save(UserDto userDto);
    UserModel findById(Long id);
    UserModel update(Long id, UserDto userDto);
    String delete(String id);
    List<UserModel> getAllByActiveTurn();
    UserModel findByUserName(String userName);
    UserModel findByUserId(String userId);
}
