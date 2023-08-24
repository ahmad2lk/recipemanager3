package recipemanager.projekt.recipemanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.controller.request.StepRequest;
import recipemanager.projekt.recipemanager.model.Step;
import recipemanager.projekt.recipemanager.service.StepService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/step")
@PreAuthorize("hasRole('ADMIN')")
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {

        this.stepService = stepService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Step>> getAllSteps() {
        List<Step> steps = stepService.findAllSteps();
        return new ResponseEntity<>(steps, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Step> getStepById(@PathVariable("id") Long id) {
        Step step = stepService.findStepById(id);
        return new ResponseEntity<>(step, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Step> addStep(@RequestBody Step step) {
        Step newStep = stepService.addStep(step);
        return new ResponseEntity<>(newStep , HttpStatus.CREATED);
    }
}
