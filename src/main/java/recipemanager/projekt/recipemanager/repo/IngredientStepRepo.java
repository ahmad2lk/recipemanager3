package recipemanager.projekt.recipemanager.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import recipemanager.projekt.recipemanager.model.IngredientStep;

import java.util.Optional;

@Repository
public interface IngredientStepRepo extends JpaRepository<IngredientStep,Long > {
    Optional<Object> findIngredientStepById(Long id);

    @Transactional
    IngredientStep save(IngredientStep ingredientStep);


}
