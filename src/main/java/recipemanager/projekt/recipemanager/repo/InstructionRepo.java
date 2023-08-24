package recipemanager.projekt.recipemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.projekt.recipemanager.model.Instruction;

import java.util.Optional;

@Repository
public interface InstructionRepo extends JpaRepository<Instruction,Long > {
    Optional<Object> findInstructionById(Long id);
}
