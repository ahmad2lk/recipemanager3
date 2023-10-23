package recipemanager.projekt.recipemanager.user.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.UserNotFoundException;
import recipemanager.projekt.recipemanager.user.controller.auth.UserResponse;
import recipemanager.projekt.recipemanager.user.model.User;
import recipemanager.projekt.recipemanager.user.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;



    public List<UserResponse> allUsers(String jwtToken) {
        List<User> users = userRepo.findAll();

        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setFirstname(user.getFirstname());
            userResponse.setLastname(user.getLastname());
            userResponse.setEmail(user.getEmail());
            userResponse.setRole(user.getRole());
            userResponses.add(userResponse);
        }

        return userResponses;
    }

    public UserResponse findUserById(Long id, String jwtToken) {

        Optional<User> userOptional = userRepo.getUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setFirstname(user.getFirstname());
            userResponse.setLastname(user.getLastname());
            userResponse.setEmail(user.getEmail());
            userResponse.setRole(user.getRole());
            return userResponse;
        } else {
            throw new UserNotFoundException("Benutzer with ID " + id + " not Found.");
        }
    }

}
