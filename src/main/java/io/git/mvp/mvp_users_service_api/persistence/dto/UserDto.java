package io.git.mvp.mvp_users_service_api.persistence.dto;

import io.git.mvp.mvp_users_service_api.persistence.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class UserDto implements Serializable {
    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty
    @NotBlank(message = "Nome não pode ser vazio")
    String name;
    @NotNull(message = "Email não pode ser nulo")
    @Email
    @NotEmpty
    @NotBlank(message = "Email não pode ser vazio")
    String email;

    public static User toDto(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
