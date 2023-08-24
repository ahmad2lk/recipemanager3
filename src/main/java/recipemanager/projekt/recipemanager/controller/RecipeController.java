package recipemanager.projekt.recipemanager.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.model.Recipe;
import recipemanager.projekt.recipemanager.service.RecipeService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/recipe")
@PreAuthorize("hasAnyRole('ADMIN' ,'USER')")
public class RecipeController {


    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }




    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('admin:read', 'user:read')")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        log.info("Received fetching  request");
        List<Recipe> recipes = recipeService.findAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('admin:read', 'user:read')")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) {
        log.info("Received fetching  request");
        Recipe recipe = recipeService.findRecipesById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }


    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        try {
            Recipe newRecipe = recipeService.addRecipe(recipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        } catch (Exception e) {
            log.info("Received add  request");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/update")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeService.updateRecipe(recipe);
        log.info("Received update  request");
        return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable("id") Long     toId) {
        log.info("Received update  request");
        recipeService.deleteRecipe(toId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
