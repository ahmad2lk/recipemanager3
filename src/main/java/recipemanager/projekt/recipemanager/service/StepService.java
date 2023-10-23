package recipemanager.projekt.recipemanager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.StepNotFoundException;

import recipemanager.projekt.recipemanager.model.*;
import recipemanager.projekt.recipemanager.repo.StepRepo;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StepService {

    private final StepRepo stepRepo;



    public Step addStep(Step step) {

        return stepRepo.save(step);
    }



    public List<Step> findAllSteps() {
        return stepRepo.findAll();
    }

    public Step findStepById(Long id) {
        return (Step) stepRepo.findStepById(id)
                .orElseThrow(()
                -> new StepNotFoundException("Step by id " + id + "was not found "));
    }


}
