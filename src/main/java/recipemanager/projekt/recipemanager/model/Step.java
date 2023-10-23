package recipemanager.projekt.recipemanager.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Die Klasse `Step` repräsentiert einen Schritt in der Recipe Manager-Anwendung. Ein Schritt enthält eine Liste von
 * Zutatenschritten (Ingredient Steps) und Anweisungen (Instructions), die für die Zubereitung eines Rezepts benötigt werden.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "steps")
public class Step implements Serializable {

    @Id
    @SequenceGenerator(
            name = "step_sequence",
            sequenceName = "step_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "step_sequence")
    @Column(name = "step_id", nullable = false, updatable = false)
    private Long id;

    /**
     * Die Liste der Zutatenschritte, die zu diesem Schritt gehören. Die Beziehung wird durch das `ingredientSteps`-Feld
     * dargestellt.
     */
    @OneToMany(mappedBy = "step")
    @JsonManagedReference("steps_ingredientSteps")
    private List<IngredientStep> ingredientSteps = new ArrayList<>();

    /**
     * Die Liste der Anweisungen, die zu diesem Schritt gehören. Die Beziehung wird durch das `instructions`-Feld dargestellt.
     */
    @OneToMany(mappedBy = "step", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "step_instructions")
    private List<Instruction> instructions;

    /**
     * Das Rezept, zu dem dieser Schritt gehört. Die Beziehung wird durch das `recipe`-Feld dargestellt.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @JsonBackReference(value = "recipe_steps")
    private Recipe recipe;
}
