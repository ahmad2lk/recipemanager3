package recipemanager.projekt.recipemanager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.IngredientsNotFoundException;
import recipemanager.projekt.recipemanager.model.*;
import recipemanager.projekt.recipemanager.repo.IngredientRepo;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
 public class IngredientService {

     private final IngredientRepo ingredientRepo;



    public Ingredient addIngredient(Ingredient newIngredient) {


          return ingredientRepo.save(newIngredient );
    }

    public List<Ingredient> findAllIngredients() {
        return ingredientRepo.findAll();
    }

    public Ingredient findIngredientById(Long id) {
        return (Ingredient) ingredientRepo.findIngredientsById(id)
                .orElseThrow(()
                -> new IngredientsNotFoundException("Ingredient by id " + id + "was not found "));
    }



}
