package project_api.config.securiy;


import java.util.Optional;

public interface ApplicationUserService {
    Optional<AuthUser> loadUserByUserName(String username);
}
