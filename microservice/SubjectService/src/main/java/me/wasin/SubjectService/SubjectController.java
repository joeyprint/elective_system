package me.wasin.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubject() {
        List<Subject> subject_object = subjectService.getAllSubject();
        return new ResponseEntity<List<Subject>>(subject_object, HttpStatus.OK);
    }

    @GetMapping("/subject/{subject_id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable(name = "subject_id") int id) {
        Subject subject_object = subjectService.getSubjectById(id);
        return new ResponseEntity<Subject>(subject_object, HttpStatus.OK);
    }

    @PostMapping("/subject")
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody Subject subject) {
        Subject subject_object = subjectService.createSubject(subject);
        return new ResponseEntity<Subject>(subject_object, HttpStatus.OK);
    }

    @PutMapping("/subject/{subject_id}/edit")
    public ResponseEntity<Subject> updateDataSubject(@PathVariable(name = "subject_id") int id,
                                                 @Valid @RequestBody Subject subject) {
        Subject subject_object = subjectService.updateSubject(id, subject);
        return new ResponseEntity<Subject>(subject_object, HttpStatus.OK);
    }

    @DeleteMapping("/subject/{subject_id}/delete")
    public ResponseEntity<Subject> deleteSubject(@PathVariable(name = "subject_id") int id) {
        Subject subject_object = subjectService.deleteSubject(id);
        return new ResponseEntity<Subject>(subject_object, HttpStatus.OK);
    }
}
