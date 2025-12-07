package io.git.mvp.mvp_users_service_api.services;

import io.git.mvp.mvp_users_service_api.persistence.dto.UserDto;
import io.git.mvp.mvp_users_service_api.persistence.dto.UserSavedDto;
import io.git.mvp.mvp_users_service_api.persistence.models.User;
import io.git.mvp.mvp_users_service_api.persistence.repositories.UserRepository;
import org.apache.coyote.BadRequestException;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    private final UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    public Iterable<UserSavedDto> findAll(){
        return this.repository.findAll().stream().map(UserSavedDto::of).toList();
    }

    public UserSavedDto create(UserDto userDto){
        User createdUser = this.repository.save(UserDto.toDto(userDto));
        return UserSavedDto.of(createdUser);
    }

    public UserSavedDto findById(Integer id) {
        Optional<User> byId = this.repository.findById(id);
        if (byId.isEmpty()) {
            throw new ResourceNotFoundException("Usuario " + id + " não encontrado");
        }
        return UserSavedDto.of(byId.get());
    }

    public void update(Integer id, UserDto userDto) throws BadRequestException {
        try {
            this.repository.findById(id).ifPresent(user -> {
                user.setName(userDto.getName());
                user.setEmail(userDto.getEmail());
                this.repository.save(user);
            });
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BadRequestException("Ocorreu um erro ao dar update no usuario");
        }
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
