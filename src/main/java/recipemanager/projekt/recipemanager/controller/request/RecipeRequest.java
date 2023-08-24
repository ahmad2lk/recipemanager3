package recipemanager.projekt.recipemanager.controller.request;

import com.sun.jdi.request.StepRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
