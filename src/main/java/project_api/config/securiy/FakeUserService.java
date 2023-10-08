package project_api.config.securiy;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FakeUserService implements ApplicationUserService{

    private final PasswordEncoder passwordEncoder;
    @Override
    public Optional<AuthUser> loadUserByUserName(String username) {
        return getAuthUser().stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
    private List<AuthUser> getAuthUser(){
        AuthUser khim = new AuthUser("khim",passwordEncoder.encode("123"),RoleEnum.ADMIN.getAuthorities(),true,true,true,true);
        AuthUser khat = new AuthUser("khat",passwordEncoder.encode("123"),RoleEnum.USER.getAuthorities(),true,true,true,true);
        return List.of(khim,khat);
    }
}
