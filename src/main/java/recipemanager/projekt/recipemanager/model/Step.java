package recipemanager.projekt.recipemanager.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "steps")
public class Step  implements Serializable {

    @Id
    @SequenceGenerator(
            name = "step_sequence",
            sequenceName = "step_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "step_sequence"
    )
    @Column( name = "step_id",
            nullable = false ,
            updatable = false )
    private Long id;



    @OneToMany(mappedBy = "step" )
    @JsonManagedReference("steps_ingredientSteps")
    private List<IngredientStep> ingredientSteps    = new ArrayList<>();;


    @OneToMany(mappedBy = "step",fetch = FetchType.LAZY)
    @JsonManagedReference(value = "step_instructions")
    private List<Instruction> instructions ;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @JsonBackReference(value = "recipe_steps")
    private Recipe recipe;



}
