package recipemanager.projekt.recipemanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.InstructionNotFoundException;
import recipemanager.projekt.recipemanager.model.CookMixInstruction;
import recipemanager.projekt.recipemanager.model.Instruction;
import recipemanager.projekt.recipemanager.repo.CookMixInstructionRepo;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CookMixInstructionService {



    private final CookMixInstructionRepo cookMixInstructionRepo;




    public CookMixInstruction addCookMixInstruction(CookMixInstruction cookMixInstruction) {

        return cookMixInstructionRepo.save(cookMixInstruction);
    }

    public List<? extends Instruction> findAllCookMixInstructions() {
        return cookMixInstructionRepo.findAll();
    }




    public CookMixInstruction findCookMixInstructionById(Long id) {
        return (CookMixInstruction) cookMixInstructionRepo.findCookMixInstructionById(id)
                .orElseThrow(()
                -> new InstructionNotFoundException
                        ("CookMixInstruction by id " + id + "was not found "));
    }

}
