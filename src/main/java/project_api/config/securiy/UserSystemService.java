package project_api.config.securiy;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import project_api.mapper.AuthUserMapper;
import project_api.model.UserModel;
import project_api.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class UserSystemService implements ApplicationUserService{
    /*
      get user from db
     */
    private final UserRepository userRepository;

    /**
     * @param username
     * @return
     */
    @Override
    public Optional<AuthUser> loadUserByUserName(String username) {
        UserModel user = userRepository.findByUsername(username);
        return Optional.ofNullable( AuthUserMapper.INSTANCE.toAuthUser(user));
    }
}
