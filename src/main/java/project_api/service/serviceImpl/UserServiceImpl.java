package project_api.service.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project_api.dto.UserDto;
import project_api.exception.ApiException;
import project_api.mapper.UserMapper;
import project_api.model.AddressModel;
import project_api.model.UserModel;
import project_api.repository.AddressRepository;
import project_api.repository.UserRepository;
import project_api.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    @Override
    public UserModel save(UserDto userDto) {
        AddressModel address = addressRepository.save(userDto.getAddress());
        userDto.setAddress(address);
        return userRepository.save(UserMapper.INSTANCE.toModel(userDto));
    }

    @Override
    public UserModel findById(Long id) throws ApiException{
        return userRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,"User not found for id: " + id));
    }

    @Override
    public UserModel update(Long id, UserDto userDto) {
        // update address
        AddressModel address = addressRepository.findById(userDto.getAddress().getId()).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,"Address not found for id: " + id));
        BeanUtils.copyProperties(userDto.getAddress(), address, "id");
        addressRepository.save(address);
        // update userInfo
        UserModel user = findById(id);
        BeanUtils.copyProperties(userDto, user, "id");
        return userRepository.save(user);
    }

    @Override
    public String delete(String id) {
        UserModel user = findByUserId(id);
        user.setActive(false);
        userRepository.save(user);
        return "User id:" + user.getUserId() + " successfully deleted";
    }

    @Override
    public List<UserModel> getAllByActiveTurn() {
       return userRepository.findByActiveTrueOrderByIdAsc();
    }

    @Override
    public UserModel findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public UserModel findByUserName(String userName) {
        return userRepository.findByUsername(userName); 
    }
    
}
