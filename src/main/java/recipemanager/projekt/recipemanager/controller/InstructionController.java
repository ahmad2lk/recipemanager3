package recipemanager.projekt.recipemanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import recipemanager.projekt.recipemanager.model.Instruction;
import recipemanager.projekt.recipemanager.service.InstructionService;


import java.util.List;
/**
 * Dies ist ein Spring Boot Controller, der Endpunkte für die Verwaltung von Anweisungen bereitstellt.
 * Nur Benutzer mit der Rolle 'ADMIN' dürfen auf diese Endpunkte zugreifen.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/instruction")
@PreAuthorize("hasRole('ADMIN')")
public class InstructionController {

    private final InstructionService instructionService;

    /**
     * Erstellt eine neue Instanz des InstructionController mit dem gegebenen InstructionService.
     *
     * @param instructionService Der InstructionService, der für die Anweisungen verwendet wird.
     */


    /**
     * Gibt alle Anweisungen zurück.
     *
     * @return Eine ResponseEntity mit einer Liste von Anweisungen und dem HTTP-Statuscode OK.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Instruction>> getAllInstructions() {
        List<Instruction> instructions = instructionService.findAllInstructions();
        return new ResponseEntity<>(instructions, HttpStatus.OK);
    }

    /**
     * Sucht eine Anweisung anhand der ID.
     *
     * @param id Die ID der gesuchten Anweisung.
     * @return Eine ResponseEntity mit der gefundenen Anweisung und dem HTTP-Statuscode OK.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Instruction> getInstructionById(@PathVariable("id") Long id) {
        Instruction instruction = instructionService.findInstructionById(id);
        return new ResponseEntity<>(instruction, HttpStatus.OK);
    }

    /**
     * Fügt eine neue Anweisung hinzu.
     *
     * @param instruction Die hinzuzufügende Anweisung.
     * @return Eine ResponseEntity mit der neu hinzugefügten Anweisung und dem HTTP-Statuscode CREATED.
     */
    @PostMapping("/add")
    public ResponseEntity<Instruction> addInstruction(@RequestBody Instruction instruction) {
        Instruction newInstruction = instructionService.addInstruction(instruction);
        return new ResponseEntity<>(newInstruction, HttpStatus.CREATED);
    }
}