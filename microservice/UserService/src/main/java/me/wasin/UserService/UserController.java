package me.wasin.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> user_object = userService.getAllUser();
        return new ResponseEntity<List<User>>(user_object, HttpStatus.OK);
    }

    @GetMapping("/user/{student_id}")
    public ResponseEntity<User> getUserByStudentId(@PathVariable(name = "student_id") String id) {
        User user_object = userService.getUserById(id);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User user_object = userService.insertUser(user);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

    @PutMapping("/user/{student_id}/edit")
    public ResponseEntity<User> editUser(@PathVariable(name = "student_id") String id,
                                         @Valid @RequestBody User user) {
        User user_object = userService.updateDataById(id, user);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

    @DeleteMapping("/user/{student_id}/delete")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "student_id") String id) {
        User user_object = userService.deleteUser(id);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }
}
