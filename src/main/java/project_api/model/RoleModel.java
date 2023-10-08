package project_api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<UserModel> user;
}
