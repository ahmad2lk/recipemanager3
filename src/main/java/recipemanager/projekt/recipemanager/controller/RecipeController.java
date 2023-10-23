package recipemanager.projekt.recipemanager.controller;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.model.Recipe;
import recipemanager.projekt.recipemanager.service.RecipeService;

import java.util.List;
/**
 * Controller-Klasse, die Endpunkte für die Verwaltung von Rezepten bereitstellt.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipe")
@PreAuthorize("hasAnyRole('ADMIN' ,'USER')")
public class RecipeController {

    private final RecipeService recipeService;

    /**
     * Ruft alle Rezepte ab.
     *
     * @param jwtToken Das JWT-Token des Benutzers.
     * @return ResponseEntity mit einer Liste von Rezepten und dem HTTP-Statuscode OK.
     */
    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('admin:read', 'user:read')")
    public ResponseEntity<List<Recipe>> getAllRecipes(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        log.info("Received fetching request");
        List<Recipe> recipes = recipeService.findAllRecipes(jwtToken);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    /**
     * Ruft ein Rezept anhand seiner ID ab.
     *
     * @param jwtToken Das JWT-Token des Benutzers.
     * @param id Die ID des abzurufenden Rezepts.
     * @return ResponseEntity mit dem abgerufenen Rezept und dem HTTP-Statuscode OK.
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('admin:read', 'user:read')")
    public ResponseEntity<Recipe> getRecipeById( @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                 @PathVariable("id") Long id) {
        log.info("Received fetching request");
        Recipe recipe = recipeService.findRecipesById(id, jwtToken);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    /**
     * Fügt ein neues Rezept hinzu.
     *
     * @param jwtToken Das JWT-Token des Benutzers.
     * @param recipe Das hinzuzufügende Rezept.
     * @return ResponseEntity mit dem hinzugefügten Rezept und dem HTTP-Statuscode CREATED.
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Recipe> addRecipe( @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                             @RequestBody Recipe recipe) {

        Recipe newRecipe = recipeService.addRecipe(recipe, jwtToken);
        log.info("Received add request");
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    /**
     * Aktualisiert ein vorhandenes Rezept.
     *
     * @param jwtToken Das JWT-Token des Benutzers.
     * @param recipe Das aktualisierte Rezept.
     * @return ResponseEntity mit dem aktualisierten Rezept und dem HTTP-Statuscode OK.
     */
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Recipe> updateRecipe( @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                @RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeService.updateRecipe(recipe, jwtToken);
        log.info("Received update request");
        return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
    }

    /**
     * Löscht ein Rezept anhand seiner ID.
     *
     * @param jwtToken Das JWT-Token des Benutzers.
     * @param id Die ID des zu löschenden Rezepts.
     * @return ResponseEntity mit dem HTTP-Statuscode OK.
     */
    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<Recipe> deleteRecipe( @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                @PathVariable("id") Long id) {
        log.info("Received delete request");
        recipeService.deleteRecipe(id, jwtToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Aktualisiert den Preis eines Rezepts anhand seiner ID.
     *
     * @param jwtToken Das JWT-Token des Benutzers.
     * @param id Die ID des Rezepts, dessen Preis aktualisiert werden soll.
     * @param price Der neue Preis für das Rezept.
     * @return ResponseEntity mit dem HTTP-Statuscode OK.
     */
    @PutMapping("setPrice/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Recipe> setPriceRecipe( @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                  @PathVariable("id") Long id,
                                                  @PathVariable("price") Double price) {
        recipeService.setRecipePrice(id, price, jwtToken);
        log.info("Received update request");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Erstellt eine Kopie eines vorhandenen Rezepts anhand der ID.
     *
     * @param jwtToken Das JWT-Token des Benutzers.
     * @param id Die ID des zu klonenden Rezepts.
     * @param recipe Die Kopie des Rezepts.
     * @return ResponseEntity mit dem HTTP-Statuscode OK.
     */
    @PutMapping("clone/{id}")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Recipe> cloneRecipe(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                              @PathVariable("id") Long id,
                                              @RequestBody Recipe recipe) {

        recipeService.cloneRecipe(id, recipe, jwtToken);
        log.info("Received clone request");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
