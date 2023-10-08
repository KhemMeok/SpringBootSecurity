package project_api.dto;

import java.util.Date;

import lombok.Data;
import project_api.model.AddressModel;

@Data
public class UserDto {
    private Long id;
    private String userId;
    private String username;
    private String password;
    private String email;
    private String gender;
    private int age;
    private AddressModel address;
    private Date createdDate;
    private Boolean active;
}
