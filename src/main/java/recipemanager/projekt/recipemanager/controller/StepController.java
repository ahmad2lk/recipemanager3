package recipemanager.projekt.recipemanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.model.Step;
import recipemanager.projekt.recipemanager.service.StepService;
import java.util.List;
/**
 * Der `StepController` ist für die Verwaltung von Schritten (Steps)
 * in der Recipe Manager-Anwendung verantwortlich.
 * Dieser Controller bietet Endpunkte für das Abrufen aller Schritte,
 * das Abrufen eines einzelnen Schritts anhand seiner ID
 * und das Hinzufügen neuer Schritte.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/step")
@PreAuthorize("hasRole('ADMIN')")
public class StepController {

    private final StepService stepService;

    /**
     * Diese Methode behandelt Anfragen, um alle Schritte abzurufen.
     *
     * @return Eine ResponseEntity mit einer Liste von Schritten und dem HTTP-Status "OK".
     */
    @GetMapping("/all")
    public ResponseEntity<List<Step>> getAllSteps() {
        List<Step> steps = stepService.findAllSteps();
        return new ResponseEntity<>(steps, HttpStatus.OK);
    }

    /**
     * Diese Methode behandelt Anfragen, um einen Schritt anhand seiner ID abzurufen.
     *
     * @param id Die eindeutige ID des Schritts, der abgerufen werden soll.
     * @return Eine ResponseEntity mit dem abgerufenen Schritt und dem HTTP-Status "OK".
     */
    @GetMapping("/{id}")
    public ResponseEntity<Step> getStepById(@PathVariable("id") Long id) {
        Step step = stepService.findStepById(id);
        return new ResponseEntity<>(step, HttpStatus.OK);
    }

    /**
     * Diese Methode behandelt Anfragen zum Hinzufügen eines neuen Schritts.
     *
     * @param step Der zu erstellende Schritt, der im (RequestBody) übergeben wird.
     * @return Eine ResponseEntity mit dem erstellten Schritt und dem HTTP-Status "Erstellt" (201).
     */
    @PostMapping("/add")
    public ResponseEntity<Step> addStep(@RequestBody Step step) {
        Step newStep = stepService.addStep(step);
        return new ResponseEntity<>(newStep, HttpStatus.CREATED);
    }
}
