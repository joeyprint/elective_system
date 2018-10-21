package me.wasin.ElectiveService.Elective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ElectiveController {

    @Autowired
    private ElectiveService electiveService;

    @GetMapping("/electives")
    public ResponseEntity<List<Elective>> getAllElective() {
        List<Elective> elective_object = electiveService.getAllElective();
        return new ResponseEntity<List<Elective>>(elective_object, HttpStatus.OK);
    }

    @GetMapping("/elective/{id}")
    public ResponseEntity<Elective> getElectiveById(@PathVariable(name = "id") int id) {
        Elective elective_object = electiveService.getElectiveById(id);
        return new ResponseEntity<Elective>(elective_object, HttpStatus.OK);
    }

    @PostMapping("/elective")
    public ResponseEntity<Elective> createElective(@Valid @RequestBody Elective elective) {
        Elective elective_object = electiveService.createElective(elective);
        return new ResponseEntity<Elective>(elective_object, HttpStatus.OK);
    }

    @PutMapping("/elective/{id}/edit")
    public ResponseEntity<Elective> createElective(@PathVariable(name = "id") int id,
                                                   @Valid @RequestBody Elective elective) {
        Elective elective_object = electiveService.createElective(elective);
        return new ResponseEntity<Elective>(elective_object, HttpStatus.OK);
    }

    @DeleteMapping("/elective/{id}/delete")
    public ResponseEntity<Elective> deleteElective(@PathVariable(name = "id") int id) {
        Elective elective_object = electiveService.deleteElective(id);
        return new ResponseEntity<Elective>(elective_object, HttpStatus.OK);
    }

}
