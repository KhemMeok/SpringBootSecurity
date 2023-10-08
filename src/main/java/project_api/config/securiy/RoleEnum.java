package project_api.config.securiy;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import project_api.config.securiy.PermissionEnum;

import static project_api.config.securiy.PermissionEnum.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum RoleEnum {

    ADMIN(Set.of(USER_READ, USER_WRITE)),
    USER(Set.of(USER_READ));

    private final Set<PermissionEnum> permissionEnums;

    RoleEnum(Set<PermissionEnum> roleEnum){
        this.permissionEnums = roleEnum;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> permission = this.getPermissionEnums()
                .stream()
                .map(permissionEnums -> new SimpleGrantedAuthority(permissionEnums.getDescription()))
                .collect(Collectors.toSet());

        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + this.name());

        permission.add(role);

        return permission;
    }
}
