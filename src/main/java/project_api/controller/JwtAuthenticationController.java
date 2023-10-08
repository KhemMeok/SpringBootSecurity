// package project_api.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.DisabledException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import lombok.AllArgsConstructor;
// import project_api.config.jwt.JwtRequest;
// import project_api.config.jwt.JwtResponse;
// import project_api.config.jwt.JwtTokenUtil;
// import project_api.service.JwtUserDetailsService;

// @RestController
// @CrossOrigin
// @AllArgsConstructor
// @RequestMapping("/api/services")
// public class JwtAuthenticationController {

//   private final AuthenticationManager authenticationManager;

//   private final JwtTokenUtil jwtTokenUtil;

//   private final JwtUserDetailsService userDetailsService;

//   @PostMapping("/authenticate")
//   public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//     authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

//     final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

//     final String token = jwtTokenUtil.generateToken(userDetails);

//     return ResponseEntity.ok(new JwtResponse(token));
//   }

//   private void authenticate(String username, String password) throws Exception {
//     try {
//       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//     } catch (DisabledException e) {
//       throw new Exception("USER_DISABLED", e);
//     } catch (BadCredentialsException e) {
//       throw new Exception("INVALID_CREDENTIALS", e);
//     }
//   }
// }