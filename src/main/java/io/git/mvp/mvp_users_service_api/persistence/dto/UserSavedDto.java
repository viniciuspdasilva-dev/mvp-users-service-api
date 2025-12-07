package io.git.mvp.mvp_users_service_api.persistence.dto;

import io.git.mvp.mvp_users_service_api.persistence.models.User;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link io.git.mvp.mvp_users_service_api.persistence.models.User}
 */
@Value
public class UserSavedDto implements Serializable {
    Integer id;
    String name;
    String email;

    public UserSavedDto(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static UserSavedDto of(User entity) {
        return new UserSavedDto(entity.getId(), entity.getName(), entity.getEmail());
    }
}
