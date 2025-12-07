
package io.git.mvp.mvp_users_service_api.persistence.repositories;

import io.git.mvp.mvp_users_service_api.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
