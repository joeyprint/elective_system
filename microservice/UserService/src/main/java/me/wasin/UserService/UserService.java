package me.wasin.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findByStudentId(id);
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public User updateDataById(String id, User userRequest) {
        User user = userRepository.findByStudentId(id);
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setDepartment(userRequest.getDepartment());
        user.setFaculty(userRequest.getFaculty());
        user.setYear(userRequest.getYear());
        return userRepository.save(user);
    }

    public User deleteUser(String id) {
        User user = userRepository.findByStudentId(id);
        userRepository.delete(user);
        return user;
    }
}
