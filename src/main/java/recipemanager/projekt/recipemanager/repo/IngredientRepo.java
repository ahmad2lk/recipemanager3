package recipemanager.projekt.recipemanager.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.projekt.recipemanager.model.Ingredient;

import java.util.Optional;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient,Long > {
    Optional<Object> findIngredientsById(Long id);
}
