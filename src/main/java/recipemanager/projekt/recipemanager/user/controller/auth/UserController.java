package recipemanager.projekt.recipemanager.user.controller.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.user.service.UserService;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/management")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    private final UserService userService;


    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<UserResponse>> getAllUsers(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
       List<UserResponse> users = userService.allUsers(jwtToken);
       log.info("Received fetching users request");
       return new ResponseEntity<>( users,HttpStatus.OK);
    }


    @GetMapping("/id")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<UserResponse> getAllUserById(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
            @PathVariable Long id) {
        UserResponse user = userService.findUserById(id, jwtToken);
        log.info("Received fetching users request");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
