package recipemanager.projekt.recipemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


/**
 * Die Klasse `Instruction` repräsentiert eine Anweisung in der Recipe Manager-Anwendung. Eine Anweisung enthält eine Beschreibung
 * der auszuführenden Aufgaben und ist Teil eines Schritts. Diese Klasse wird für die Verwaltung von verschiedenen Arten von
 * Anweisungen verwendet, wobei der Anweisungstyp durch die Disriminator-Spalte "instruction_type" angegeben wird.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "instructions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "instruction_type", discriminatorType = DiscriminatorType.STRING)
public class Instruction implements Serializable {

    @Id
    @SequenceGenerator(
            name = "instruction_sequence",
            sequenceName = "instruction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "instruction_sequence")
    @Column(name = "instruction_id",
            nullable = false,
            updatable = false)
    private Long id;

    /**
     * Die Beschreibung der Anweisung, die die auszuführenden Aufgaben erläutert.
     */
    @Column(name = "description",
            nullable = false)
    private String description;

    /**
     * Der Schritt, zu dem diese Anweisung gehört.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "step_id")
    @JsonBackReference(value = "step_instructions")
    private Step step;
}
