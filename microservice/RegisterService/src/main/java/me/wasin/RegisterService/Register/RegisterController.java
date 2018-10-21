package me.wasin.RegisterService.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/registers")
    public ResponseEntity<List<Register>> getAllRegister() {
        List<Register> register_object = registerService.getAll();
        return new ResponseEntity<List<Register>>(register_object, HttpStatus.OK);
    }

    @GetMapping("/registers/{student_id}")
    public ResponseEntity<List<Register>> getRegisterByStudentId(@PathVariable(name = "student_id") String id) {
        List<Register> register_object = registerService.getRegisterByUserId(id);
        return new ResponseEntity<List<Register>>(register_object, HttpStatus.OK);
    }

    @GetMapping("/registers/{elective_id}")
    public ResponseEntity<List<Register>> getRegisterByElectiveId(@PathVariable(name = "elective_id") int id) {
        List<Register> register_object = registerService.getRegisterByElectiveId(id);
        return new ResponseEntity<List<Register>>(register_object, HttpStatus.OK);
    }

    @PostMapping("/user/{student_id}/register/{elective_id}")
    public ResponseEntity<Register> createRegister(@PathVariable(name = "student_id") String studentId,
                                   @PathVariable(name = "elective_id") int electiveId,
                                   @Valid @RequestBody Register register){
        Register register_object = registerService.createRegister(studentId, electiveId, register);
        return new ResponseEntity<Register>(register_object, HttpStatus.OK);
    }

}
