package recipemanager.projekt.recipemanager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.RecipeNotFoundException;


import recipemanager.projekt.recipemanager.model.Recipe;
import recipemanager.projekt.recipemanager.repo.RecipeRepo;

import java.util.List;

/**
 * Eine Serviceklasse zur Verwaltung von Rezepten.
 */
@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepo recipeRepo;

    /**
     * Fügt ein neues Rezept hinzu und speichert es in der Datenbank.
     *
     * @param recipe Das hinzuzufügende Rezept.
     * @param jwtToken Das JWT-Token zur Authentifizierung.
     * @return Das hinzugefügte Rezept.
     */
    public Recipe addRecipe(Recipe recipe, String jwtToken) {
        return recipeRepo.save(recipe);
    }

    /**
     * Ruft alle Rezepte aus der Datenbank ab.
     *
     * @param jwtToken Das JWT-Token zur Authentifizierung.
     * @return Eine Liste aller Rezepte.
     */
    public List<Recipe> findAllRecipes(String jwtToken) {

        return recipeRepo.findAll()
                         .stream()
                         .toList();
    }

    /**
     * Sucht ein Rezept anhand seiner ID und gibt es zurück. Werfen Sie eine Ausnahme, wenn das Rezept nicht gefunden wurde.
     *
     * @param id       Die ID des zu suchenden Rezepts.
     * @param jwtToken Das JWT-Token zur Authentifizierung.
     * @return Das gefundene Rezept.
     * @throws RecipeNotFoundException Wenn das Rezept nicht gefunden wurde.
     */
    public Recipe findRecipesById(Long id, String jwtToken) {
        return recipeRepo.findRecipeById(id)
                .orElseThrow(() ->
                        new RecipeNotFoundException("Rezept mit der ID " + id + " wurde nicht gefunden."));
    }

    /**
     * Aktualisiert ein bestehendes Rezept und speichert die Änderungen in der Datenbank.
     *
     * @param recipe   Das zu aktualisierende Rezept.
     * @param jwtToken Das JWT-Token zur Authentifizierung.
     * @return Das aktualisierte Rezept.
     */
    public Recipe updateRecipe(Recipe recipe, String jwtToken) {
        return recipeRepo.save(recipe);
    }

    /**
     * Löscht ein Rezept anhand seiner ID aus der Datenbank.
     *
     * @param id       Die ID des zu löschenden Rezepts.
     * @param jwtToken Das JWT-Token zur Authentifizierung.
     */
    public void deleteRecipe(Long id, String jwtToken) {
        recipeRepo.deleteRecipeById(id);
    }

    /**
     * Legt den Preis für ein Rezept fest.
     *
     * @param id       Die ID des Rezepts, für das der Preis festgelegt werden soll.
     * @param price    Der Preis, der festgelegt werden soll.
     * @param jwtToken Das JWT-Token zur Authentifizierung.
     * @return Das aktualisierte Rezept mit dem festgelegten Preis.
     */
    public Recipe setRecipePrice(Long id, Double price, String jwtToken) {
        Recipe recipe = findRecipesById(id, jwtToken);
        recipe.setPrice(price);
        return recipe;
    }

    /**
     * Erstellt eine Kopie eines vorhandenen Rezepts und fügt es der Datenbank hinzu.
     *
     * @param id       Die ID des ursprünglichen Rezepts, das geklont werden soll.
     * @param recipe   Das Rezept, das geklont werden soll.
     * @param jwtToken Das JWT-Token zur Authentifizierung.
     * @return Das geklonte Rezept, das in der Datenbank gespeichert wurde.
     */
    public Recipe cloneRecipe(Long id, Recipe recipe, String jwtToken) {
        Recipe originalRecipe = findRecipesById(id, jwtToken);

        Recipe clonedRecipe = new Recipe();

        clonedRecipe.setName(recipe.getName());
        clonedRecipe.setDesignation(recipe.getDesignation());
        clonedRecipe.setPrice(originalRecipe.getPrice());
        clonedRecipe.setIngredients(originalRecipe.getIngredients());
        clonedRecipe.setSteps(originalRecipe.getSteps());

        Recipe savedClonedRecipe = addRecipe(clonedRecipe, jwtToken);

        return savedClonedRecipe;
    }
}
