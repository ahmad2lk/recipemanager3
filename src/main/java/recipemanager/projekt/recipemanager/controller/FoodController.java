package recipemanager.projekt.recipemanager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.model.Food;
import recipemanager.projekt.recipemanager.service.FoodService;

import java.util.List;
/**
 * Der `FoodController` ist für die Verwaltung von Lebensmitteln (Foods) in der Recipe Manager-Anwendung verantwortlich.
 * Dieser Controller bietet Endpunkte für das Abrufen aller Lebensmittel, das Abrufen eines einzelnen Lebensmittels
 * anhand seiner ID und das Hinzufügen neuer Lebensmittel.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/food")
@PreAuthorize("hasRole('ADMIN')")
public class FoodController {

    private final FoodService foodService;

    /**
     * Diese Methode behandelt Anfragen, um alle Lebensmittel abzurufen.
     *
     * @param jwtToken Der JWT-Token aus dem Autorisierungs-Header der Anfrage.
     * @return Eine ResponseEntity mit einer Liste von Lebensmitteln und dem HTTP-Status "OK".
     */
    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        List<Food> foods = foodService.findAllFoods(jwtToken);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    /**
     * Diese Methode behandelt Anfragen, um ein Lebensmittel anhand seiner ID abzurufen.
     *
     * @param jwtToken Der JWT-Token aus dem Autorisierungs-Header der Anfrage.
     * @param id Die eindeutige ID des abzurufenden Lebensmittels.
     * @return Eine ResponseEntity mit dem abgerufenen Lebensmittel und dem HTTP-Status "OK".
     */
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
            @PathVariable("id") Long id) {
        Food food = foodService.findFoodById(id, jwtToken);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    /**
     * Diese Methode behandelt Anfragen zum Hinzufügen eines neuen Lebensmittels.
     *
     * @param jwtToken Der JWT-Token aus dem Autorisierungs-Header der Anfrage.
     * @param food Das zu erstellende Lebensmittel, das im (RequestBody) übergeben wird.
     * @return Eine ResponseEntity mit dem erstellten Lebensmittel und dem HTTP-Status "Erstellt" (201).
     */
    @PostMapping("/add")
    public ResponseEntity<Food> addFood(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
            @RequestBody Food food) {
        Food newFood = foodService.addFood(food, jwtToken);
        return new ResponseEntity<>(newFood, HttpStatus.CREATED);
    }
}
