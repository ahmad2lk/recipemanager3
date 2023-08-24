package recipemanager.projekt.recipemanager.exception;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(String message) {

        super (message);
    }
}
