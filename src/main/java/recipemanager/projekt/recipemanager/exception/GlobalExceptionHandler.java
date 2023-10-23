package recipemanager.projekt.recipemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Diese Klasse fungiert als globaler Ausnahmebehandler für die Behandlung von benutzerdefinierten Ausnahmen in der Recipe Manager-Anwendung.
 * Sie bietet Methoden zur Behandlung verschiedener benutzerdefinierter Ausnahmen und zur Rückgabe geeigneter HTTP-Antworten.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Behandelt die Ausnahme, wenn ein Rezept nicht gefunden wurde.
     *
     * @param ex Die Ausnahme vom Typ RecipeNotFoundException.
     * @return Eine ResponseEntity mit dem HTTP-Status "Nicht gefunden" und der Ausnahmemeldung als Antwortkörper.
     */
    @ExceptionHandler(RecipeNotFoundException.class)
    public ResponseEntity<String> handleRecipeNotFoundException(RecipeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Behandelt die Ausnahme, wenn ein Schritt nicht gefunden wurde.
     *
     * @param ex Die Ausnahme vom Typ StepNotFoundException.
     * @return Eine ResponseEntity mit dem HTTP-Status "Nicht gefunden" und der Ausnahmemeldung als Antwortkörper.
     */
    @ExceptionHandler(StepNotFoundException.class)
    public ResponseEntity<String> handleStepNotFoundException(StepNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Behandelt die Ausnahme, wenn Zutaten nicht gefunden wurden.
     *
     * @param ex Die Ausnahme vom Typ IngredientsNotFoundException.
     * @return Eine ResponseEntity mit dem HTTP-Status "Nicht gefunden" und der Ausnahmemeldung als Antwortkörper.
     */
    @ExceptionHandler(IngredientsNotFoundException.class)
    public ResponseEntity<String> handleIngredientsNotFoundException(IngredientsNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Behandelt die Ausnahme, wenn ein Zutatenschritt nicht gefunden wurde.
     *
     * @param ex Die Ausnahme vom Typ IngredientStepNotFoundException.
     * @return Eine ResponseEntity mit dem HTTP-Status "Nicht gefunden" und der Ausnahmemeldung als Antwortkörper.
     */
    @ExceptionHandler(IngredientStepNotFoundException.class)
    public ResponseEntity<String> handleIngredientStepNotFoundException(IngredientStepNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Behandelt die Ausnahme, wenn eine Anweisung nicht gefunden wurde.
     *
     * @param ex Die Ausnahme vom Typ InstructionNotFoundException.
     * @return Eine ResponseEntity mit dem HTTP-Status "Nicht gefunden" und der Ausnahmemeldung als Antwortkörper.
     */
    @ExceptionHandler(InstructionNotFoundException.class)
    public ResponseEntity<String> handleInstructionStepNotFoundException(InstructionNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Behandelt die Ausnahme, wenn ein Lebensmittel nicht gefunden wurde.
     *
     * @param ex Die Ausnahme vom Typ FoodNotFoundException.
     * @return Eine ResponseEntity mit dem HTTP-Status "Nicht gefunden" und der Ausnahmemeldung als Antwortkörper.
     */
    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<String> handleFoodNotFoundException(FoodNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Behandelt die Ausnahme, wenn ein Benutzer nicht gefunden wurde.
     *
     * @param ex Die Ausnahme vom Typ UserNotFoundException.
     * @return Eine ResponseEntity mit dem HTTP-Status "Nicht gefunden" und der Ausnahmemeldung als Antwortkörper.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
