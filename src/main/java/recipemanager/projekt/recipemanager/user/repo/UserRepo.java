package recipemanager.projekt.recipemanager.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.projekt.recipemanager.user.model.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> getUserById(Long userId);
}
