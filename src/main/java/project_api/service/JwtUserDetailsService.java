package project_api.service;

// import java.util.ArrayList;

// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import lombok.AllArgsConstructor;
// import project_api.model.UserModel;
// import project_api.repository.UserRepository;

// @Service
// @AllArgsConstructor
// public class JwtUserDetailsService implements UserDetailsService {

//   private final UserRepository userRepository;

//   @Override
//   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//     //Load the user from your database here
//     UserModel user = userRepository.getUserByUsername(username);
//     return new User(user.getUsername(),user.getPassword(), new ArrayList<>());
        
//   }
// }
