package recipemanager.projekt.recipemanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/admin/test")
public class TestController {

    @GetMapping("/get")
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Welcome ::GET");
    }


}
