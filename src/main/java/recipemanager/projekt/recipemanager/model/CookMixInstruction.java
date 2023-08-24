package recipemanager.projekt.recipemanager.model;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "instruction_id")
@Data

public class CookMixInstruction extends Instruction {



    private Integer duration;

    private Integer    mixingLevel;

    private Integer  temperature;


}
