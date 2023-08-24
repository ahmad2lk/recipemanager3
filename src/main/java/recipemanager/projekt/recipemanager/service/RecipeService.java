package recipemanager.projekt.recipemanager.service;




import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.RecipeNotFoundException;

import recipemanager.projekt.recipemanager.model.Ingredient;
import recipemanager.projekt.recipemanager.model.Recipe;
import recipemanager.projekt.recipemanager.model.Step;
import recipemanager.projekt.recipemanager.repo.RecipeRepo;

import java.util.List;



@Service
public class RecipeService {

    private final RecipeRepo recipeRepo;
    private final ObjectMapper objectMapper;


    public RecipeService(RecipeRepo recipeRepo, ObjectMapper objectMapper) {
        this.recipeRepo = recipeRepo;

        this.objectMapper = objectMapper;
    }


    public Recipe addRecipe(Recipe recipe)  {

        return recipeRepo.save(recipe);
    }



    public List<Recipe> findAllRecipes() {
        return recipeRepo.findAll();
    }

    public Recipe findRecipesById(Long id) {
        return recipeRepo.findRecipeById(id).orElseThrow(()
                -> new RecipeNotFoundException("Recipe by id " + id + "was not found "));
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepo.deleteRecipeById(id);
    }
}
