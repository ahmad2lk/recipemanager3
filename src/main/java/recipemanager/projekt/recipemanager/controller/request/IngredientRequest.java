package recipemanager.projekt.recipemanager.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientRequest {

    private Long id;
    private String name;
    private Integer Crowd;
    private String unit;



}
