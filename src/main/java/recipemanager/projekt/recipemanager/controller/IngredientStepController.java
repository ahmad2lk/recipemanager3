package recipemanager.projekt.recipemanager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.model.IngredientStep;
import recipemanager.projekt.recipemanager.service.IngredientStepService;

import java.util.List;
/**
 * Der `IngredientStepController` ist für die Verwaltung von Zutaten schritten (Ingredient Steps) in der Recipe Manager-Anwendung verantwortlich.
 * Dieser Controller bietet Endpunkte für das Abrufen aller Zutaten schritte, das Abrufen eines einzelnen Zutatenschritts anhand seiner ID
 * und das Hinzufügen neuer Zutaten schritte.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingredientStep")
@PreAuthorize("hasRole('ADMIN')")
public class IngredientStepController {

    private final IngredientStepService ingredientStepService;

    /**
     * Diese Methode behandelt Anfragen, um alle Zutatenschritte abzurufen.
     *
     * @return Eine ResponseEntity mit einer Liste von Zutatenschritten und dem HTTP-Status "OK".
     */
    @GetMapping("/all")
    public ResponseEntity<List<IngredientStep>> getAllIngredientStep() {
        List<IngredientStep> ingredientSteps = ingredientStepService.findAllIngredientSteps();
        return new ResponseEntity<>(ingredientSteps, HttpStatus.OK);
    }

    /**
     * Diese Methode behandelt Anfragen, um einen Zutatenschritt anhand seiner ID abzurufen.
     *
     * @param id Die eindeutige ID des Zutatenschritts, der abgerufen werden soll.
     * @return Eine ResponseEntity mit dem abgerufenen Zutatenschritt und dem HTTP-Status "OK".
     */
    @GetMapping("/{id}")
    public ResponseEntity<IngredientStep> getIngredientStepById(@PathVariable("id") Long id) {
        IngredientStep ingredientStep = ingredientStepService.findIngredientStepById(id);
        return new ResponseEntity<>(ingredientStep, HttpStatus.OK);
    }

    /**
     * Diese Methode behandelt Anfragen zum Hinzufügen eines neuen Zutatenschritts.
     *
     * @param ingredientStep Der zu erstellende Zutatenschritt, der im Anforderungskörper (RequestBody) übergeben wird.
     * @return Eine ResponseEntity mit dem erstellten Zutatenschritt und dem HTTP-Status "Erstellt" (201), oder
     *         bei einer ungültigen Anfrage mit dem HTTP-Status "Bad Request".
     */
    @PostMapping("/add")
    public ResponseEntity<IngredientStep> addIngredientStep(@RequestBody IngredientStep ingredientStep) {
        IngredientStep newIngredientStep = ingredientStepService.addIngredientStep(ingredientStep);
        if (newIngredientStep != null) {
            return new ResponseEntity<>(newIngredientStep, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
