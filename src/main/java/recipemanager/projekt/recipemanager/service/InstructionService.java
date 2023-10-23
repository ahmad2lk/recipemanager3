package recipemanager.projekt.recipemanager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.exception.InstructionNotFoundException;
import recipemanager.projekt.recipemanager.model.Instruction;
import recipemanager.projekt.recipemanager.repo.InstructionRepo;


import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructionService {


    private final InstructionRepo instructionRepo;




    public Instruction addInstruction(Instruction instruction) {

        try {
            return instructionRepo.save(instruction);
        } catch (Exception e) {
            throw new RuntimeException("Error while adding instruction", e);
        }
    }

    public List<Instruction> findAllInstructions() {
        return instructionRepo.findAll();
    }

    public Instruction findInstructionById(Long id) {
        return (Instruction) instructionRepo.findInstructionById(id)
                .orElseThrow(()
                -> new InstructionNotFoundException("Instruction by id " + id + "was not found "));
    }

}
