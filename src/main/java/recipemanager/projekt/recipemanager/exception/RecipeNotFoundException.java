package recipemanager.projekt.recipemanager.exception;

public class RecipeNotFoundException extends  RuntimeException {
    public RecipeNotFoundException(String message) {
        super(message);
    }
}
