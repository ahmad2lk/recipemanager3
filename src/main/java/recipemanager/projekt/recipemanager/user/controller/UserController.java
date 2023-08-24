/*package recipemanager.projekt.recipemanager.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import recipemanager.projekt.recipemanager.user.model.User;

import java.net.URI;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserServiceImpl userServiceImp;

    @GetMapping("/all")
    //@PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<User>> getUsers() {
        log.info("Received fetching  request");
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/api/user/save")
                        .toUriString());
        return ResponseEntity.created(uri)
                .body(userServiceImp.saveUser(user));
    }





}
*/