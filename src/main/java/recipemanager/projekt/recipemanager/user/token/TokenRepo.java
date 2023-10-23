package recipemanager.projekt.recipemanager.user.token;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * Ein Repository-Interface, das die Datenbankzugriffsmethoden für Token-Entitäten definiert.
 */
public interface TokenRepo extends JpaRepository<Token, Long> {

    /**
     * Sucht und gibt alle gültigen Token für einen bestimmten Benutzer zurück.
     *
     * @param id Die ID des Benutzers, für den die gültigen Token gesucht werden.
     * @return Eine Liste von gültigen Token für den Benutzer.
     */
    @Query(value = """
      select t from Token t inner join User u
      on t.user.id = u.id
      where u.id = :id and (t.expired = false or t.revoked = false)
      """)
    List<Token> findAllValidTokenByUser(Integer id);

    /**
     * Sucht ein Token anhand seines Wertes.
     *
     * @param token Der Wert des gesuchten Tokens.
     * @return Ein Optional, das das gefundene Token oder ein leeres Optional enthält.
     */
    Optional<Token> findByToken(String token);
}