package io.git.mvp.mvp_users_service_api.resources;

import io.git.mvp.mvp_users_service_api.persistence.dto.UserDto;
import io.git.mvp.mvp_users_service_api.persistence.dto.UserSavedDto;
import io.git.mvp.mvp_users_service_api.services.UserServices;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices services;

    public UserController(UserServices services) {
        this.services = services;
    }

    @GetMapping
    public Iterable<UserSavedDto> findAll(){
        return services.findAll();
    }

    @PostMapping
    public UserSavedDto create(@RequestBody @Valid UserDto userDto){
        return services.create(userDto);
    }

    @GetMapping("/{id}")
    public UserSavedDto findById(@PathVariable Integer id){
        return services.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UserDto userDto) throws BadRequestException {
        services.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        services.delete(id);
    }


}
