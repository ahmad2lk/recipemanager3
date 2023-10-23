package recipemanager.projekt.recipemanager.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Die Klasse `IngredientStep` repräsentiert einen Zutatenschritt in der Recipe Manager-Anwendung. Ein Zutatenschritt
 * enthält Informationen über die Menge, die Einheit, die Präsentation und Beziehungen zu einer Zutat, einem Schritt und
 * einem Lebensmittel.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ingredientSteps")
public class IngredientStep implements Serializable {

    @Id
    @SequenceGenerator(
            name = "ingredientStep_sequence",
            sequenceName = "ingredientStep_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ingredientStep_sequence")
    @Column(name = "ingredientStep_id",
            nullable = false,
            updatable = false)
    private Long id;

    /**
     * Die Menge des Zutatenschritts.
     */
    private Integer quantity;

    /**
     * Die Einheit, in der die Menge angegeben ist.
     */
    private String unit;

    /**
     * Die Präsentation des Zutatenschritts.
     */
    @Column(name = "presentation")
    private String presentation;

    /**
     * Die Zutat, die mit diesem Zutatenschritt verbunden ist.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    @JsonBackReference(value = "ingredient_ingredientSteps")
    private Ingredient ingredient;

    /**
     * Der Schritt, mit dem dieser Zutatenschritt verknüpft ist.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "step_id")
    @JsonBackReference("steps_ingredientSteps")
    private Step step;

    /**
     * Das Lebensmittel, mit dem dieser Zutatenschritt verknüpft ist.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    @JsonBackReference(value = "ingredientStep_food")
    private Food food;
}
