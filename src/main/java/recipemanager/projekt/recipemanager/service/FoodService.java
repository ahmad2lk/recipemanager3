package recipemanager.projekt.recipemanager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.FoodNotFoundException;
import recipemanager.projekt.recipemanager.model.Food;
import recipemanager.projekt.recipemanager.model.Ingredient;
import recipemanager.projekt.recipemanager.model.IngredientStep;
import recipemanager.projekt.recipemanager.repo.FoodRepo;


import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    private final FoodRepo foodRepo;
    private  final IngredientService ingredientService;
    private final  IngredientStepService ingredientStepService;

    @Autowired
    public FoodService(FoodRepo foodRepo, IngredientService ingredientService,  IngredientStepService ingredientStepService) {
        this.foodRepo = foodRepo;
        this.ingredientService = ingredientService;

        this.ingredientStepService = ingredientStepService;
    }



    public Food addFood(Food newFood) {

        return foodRepo.save(newFood);
    }


    public List<Food> findAllFoods() {
        return foodRepo.findAll();
    }

    public Food findFoodById(Long id) {
        return (Food) foodRepo.findFoodById(id).orElseThrow(()
                -> new FoodNotFoundException("Food by id " + id + "was not found "));
    }

}
