package recipemanager.projekt.recipemanager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.IngredientStepNotFoundException;
import recipemanager.projekt.recipemanager.model.IngredientStep;
import recipemanager.projekt.recipemanager.repo.IngredientStepRepo;


import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientStepService {


    private final IngredientStepRepo ingredientStepRepo;



    public IngredientStep addIngredientStep(IngredientStep ingredientStep) {

        return ingredientStepRepo.save(ingredientStep);

    }

    public List<IngredientStep> findAllIngredientSteps() {


        return ingredientStepRepo.findAll();
    }

    public IngredientStep findIngredientStepById(Long id) {
        return (IngredientStep) ingredientStepRepo.findIngredientStepById(id)
                .orElseThrow(()
                -> new IngredientStepNotFoundException("IngredientStep by id " + id + "was not found "));
    }


}
