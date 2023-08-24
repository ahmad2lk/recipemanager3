package recipemanager.projekt.recipemanager.model;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "foods")
public class Food implements Serializable {

    @Id
    @SequenceGenerator(
            name = "food_sequence",
            sequenceName = "food_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "food_sequence"
    )
    @Column(name = "food_id",
            nullable = false,
            updatable = false)
    private Long id;


    private String consistency;


    private String unit;



    @OneToMany(mappedBy = "food")
    @JsonManagedReference(value = "ingredients_food")
    private List<Ingredient> ingredients;


    @OneToMany(mappedBy = "food")
    @JsonManagedReference(value = "ingredientStep_food")
    private List<IngredientStep> ingredientSteps;


}