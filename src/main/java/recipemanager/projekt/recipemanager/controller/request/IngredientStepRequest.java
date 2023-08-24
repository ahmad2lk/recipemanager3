package recipemanager.projekt.recipemanager.controller.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientStepRequest {

    private Long id;

    private Integer quantity;
    private String unit;
    private String presentation;
    private Long ingredientId;
    private Long stepId;
    private Long foodId;

}
