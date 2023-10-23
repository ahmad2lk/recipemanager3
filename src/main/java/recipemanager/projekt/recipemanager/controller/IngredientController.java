package recipemanager.projekt.recipemanager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.model.Ingredient;
import recipemanager.projekt.recipemanager.service.IngredientService;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Der `IngredientController` ist für die Verwaltung von Zutaten (Ingredients) in der Recipe Manager-Anwendung verantwortlich.
 * Dieser Controller bietet Endpunkte für das Abrufen aller Zutaten, das Abrufen einer einzelnen Zutat anhand ihrer ID
 * und das Hinzufügen neuer Zutaten.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingredient")
@PreAuthorize("hasRole('ADMIN')")
public class IngredientController {

    private final IngredientService ingredientService;

    /**
     * Diese Methode behandelt Anfragen, um alle Zutaten abzurufen.
     *
     * @return Eine ResponseEntity mit einer Liste von Zutaten und dem HTTP-Status "OK".
     */
    @GetMapping("/all")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.findAllIngredients()
                .stream()
                .collect(Collectors.toList());
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    /**
     * Diese Methode behandelt Anfragen, um eine Zutat anhand ihrer ID abzurufen.
     *
     * @param id Die eindeutige ID der Zutat, die abgerufen werden soll.
     * @return Eine ResponseEntity mit der abgerufenen Zutat und dem HTTP-Status "OK".
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long id) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }

    /**
     * Diese Methode behandelt Anfragen zum Hinzufügen einer neuen Zutat.
     *
     * @param ingredient Die zu erstellende Zutat, die im (RequestBody) übergeben wird.
     * @return Eine ResponseEntity mit der erstellten Zutat und dem HTTP-Status "Erstellt" (201).
     */
    @PostMapping("/add")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        Ingredient newIngredient = ingredientService.addIngredient(ingredient);
        return new ResponseEntity<>(newIngredient, HttpStatus.CREATED);
    }
}
