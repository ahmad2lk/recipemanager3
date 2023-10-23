package recipemanager.projekt.recipemanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.io.Serializable;
import java.util.List;

/**
 * Die Klasse `Recipe` repräsentiert ein Rezept. Ein Rezept enthält Informationen
 * über den Namen, die Bezeichnung, den Preis und eine Liste von Zutaten und Schritten, die für die Zubereitung
 * des Rezepts erforderlich sind.
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

    @Id
    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_sequence")
    @Column(name = "recipe_id", nullable = false)
    private Long id;

    /**
     * Der Name des Rezepts.
     */
    private String name;

    /**
     * Die Bezeichnung oder Beschreibung des Rezepts.
     */
    private String designation;

    /**
     * Der Preis des Rezepts, falls zutreffend.
     */
    private Double price;

    /**
     * Die Liste der Zutaten, die für dieses Rezept benötigt werden. Die Beziehung wird durch das `ingredients`-Feld
     * dargestellt, das mit der `Ingredient`-Klasse verknüpft ist.
     */
    @JsonManagedReference(value = "ingredients_recipe")
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    /**
     * Die Liste der Schritte oder Anweisungen zur Zubereitung des Rezepts. Die Beziehung wird durch das `steps`-Feld
     * dargestellt, das mit der `Step`-Klasse verknüpft ist.
     */
    @JsonManagedReference(value = "recipe_steps")
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Step> steps;
}
