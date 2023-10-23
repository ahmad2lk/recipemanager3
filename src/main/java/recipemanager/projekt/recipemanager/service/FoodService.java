package recipemanager.projekt.recipemanager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.FoodNotFoundException;
import recipemanager.projekt.recipemanager.model.Food;
import recipemanager.projekt.recipemanager.repo.FoodRepo;


import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepo foodRepo;





    public Food addFood(Food newFood, String jwtToken) {

        return foodRepo.save(newFood);
    }


    public List<Food> findAllFoods(String jwtToken) {
        return foodRepo.findAll();
    }

    public Food findFoodById(Long id, String jwtToken) {
        return (Food) foodRepo.findFoodById(id).orElseThrow(()
                -> new FoodNotFoundException("Food by id " + id + "was not found "));
    }

}
