package recipemanager.projekt.recipemanager.controller.dto.request;

import com.sun.jdi.request.StepRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
public class RecipeRequest {


    private Long id;
    private String designation;
    private List<IngredientRequest> ingredients;
    private List<StepRequest> steps;


    public RecipeRequest() {
    }
}
