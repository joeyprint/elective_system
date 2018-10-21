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

    @PostMapping("/subject/{subject_id}/elective/add")
    public ResponseEntity<Elective> createElective(@PathVariable(name = "subject_id") int subjectId,
                                                   @Valid @RequestBody Elective elective) {
        Elective elective_object = electiveService.createElective(subjectId, elective);
        return new ResponseEntity<Elective>(elective_object, HttpStatus.OK);
    }

    @PutMapping("/elective/{id}/edit")
    public ResponseEntity<Elective> updateTotalRegister(@PathVariable(name = "id") int id,
                                                   @Valid @RequestBody Elective elective) {
        Elective elective_object = electiveService.updateTotalRegister(id, elective);
        return new ResponseEntity<Elective>(elective_object, HttpStatus.OK);
    }

    @DeleteMapping("/elective/{id}/delete")
    public ResponseEntity<Elective> deleteElective(@PathVariable(name = "id") int id) {
        Elective elective_object = electiveService.deleteElective(id);
        return new ResponseEntity<Elective>(elective_object, HttpStatus.OK);
    }

}
