package project_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import project_api.dto.ReqGetById;
import project_api.dto.ReqGetByUserName;
import project_api.dto.ReqGetUserId;
import project_api.dto.UserDto;
import project_api.model.UserModel;
import project_api.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserDto dto){
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return ResponseEntity.ok().body(userService.save(dto));
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestBody ReqGetById userId){
        return ResponseEntity.ok().body(userService.findById(userId.getId()));
    }
    @GetMapping("/getByUserId")
    public ResponseEntity<?> getByUserId(@RequestBody ReqGetUserId userId){
        return ResponseEntity.ok().body(userService.findByUserId(userId.getUserId()));
    }
    @GetMapping("/getByUserName")
    public ResponseEntity<?> getByUserName(@RequestBody ReqGetByUserName userName){
        return ResponseEntity.ok().body(userService.findByUserName(userName.getUserName()));
    }
    @PutMapping
    public ResponseEntity<?> UpdateUser(@RequestBody UserDto userDto){
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserModel user = userService.update(userDto.getId(), userDto);
        return ResponseEntity.ok().body(user);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> DeleteUser(@RequestBody ReqGetUserId userId) {
        String userDeleted = userService.delete(userId.getUserId());
        return ResponseEntity.ok().body(userDeleted);
     }
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllByActiveTurn());
    }


}
