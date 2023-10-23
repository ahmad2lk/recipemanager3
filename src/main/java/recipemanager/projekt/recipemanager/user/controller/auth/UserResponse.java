package recipemanager.projekt.recipemanager.user.controller.auth;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import recipemanager.projekt.recipemanager.user.model.Role;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {


    private Long id;

    private String firstname;
    private String lastname;
    private String email;

    private Role role;

}
