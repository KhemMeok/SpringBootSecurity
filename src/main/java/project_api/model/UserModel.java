package project_api.model;


import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import project_api.enumFile.GenderEnum;
@Data
//@Document("_users") // mongod_db
@Table(name = "users")
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String username;
    private String password;
    private String email;
    private GenderEnum gender;
    private int age;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private AddressModel address;

    private Date createdDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<RoleModel> roles;

    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    private Boolean active;
}
