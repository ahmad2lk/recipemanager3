/*package recipemanager.projekt.recipemanager.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.user.model.User;
import recipemanager.projekt.recipemanager.user.repo.UserRepo;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements  UserService{


    private  final UserRepo userRepo;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return (UserDetails) userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }


    public User saveUser(User user) {
        log.info(" Saving new user {} to  the database", user.getUsername());
        return userRepo.save(user);
    }






    public List<User> getUsers() {
        log.info(" fetching all users  ");
        return userRepo.findAll();
    }
}
*/