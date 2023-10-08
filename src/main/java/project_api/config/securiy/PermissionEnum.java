package project_api.config.securiy;

import lombok.Getter;

@Getter
public enum PermissionEnum {
    USER_READ("user:read"),USER_WRITE("user:write");

    private final String description;

    private PermissionEnum(String description){
        this.description = description;
    }


}
