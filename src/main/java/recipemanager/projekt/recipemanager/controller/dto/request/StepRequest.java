package recipemanager.projekt.recipemanager.controller.dto.request;

import lombok.*;
import lombok.experimental.SuperBuilder;
import recipemanager.projekt.recipemanager.model.Instruction;
import recipemanager.projekt.recipemanager.model.Recipe;

@Getter
@Setter
@Data
@SuperBuilder
@AllArgsConstructor
public class StepRequest {


    private Long id;
    private Instruction instruction;
    private Recipe recipe;

    public StepRequest() {
    }

    public Long getRecipeId() {

        return getRecipeId();
    }
}
