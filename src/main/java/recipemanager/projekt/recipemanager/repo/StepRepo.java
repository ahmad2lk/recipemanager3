package recipemanager.projekt.recipemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.projekt.recipemanager.model.Step;

import java.util.Optional;


@Repository
public interface StepRepo  extends JpaRepository<Step,Long > {
    Optional<Object> findStepById(Long id);
}
