package recipemanager.projekt.recipemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.projekt.recipemanager.model.Food;

import java.util.Optional;

@Repository
public interface FoodRepo extends JpaRepository<Food,Long > {
    Optional<Object> findFoodById(Long id);
}
