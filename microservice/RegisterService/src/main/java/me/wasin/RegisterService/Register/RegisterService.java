package me.wasin.RegisterService.Register;

import me.wasin.RegisterService.Elective.Elective;
import me.wasin.RegisterService.Elective.ElectiveAdapter;
import me.wasin.RegisterService.User.User;
import me.wasin.RegisterService.User.UserAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private UserAdapter userAdapter;

    @Autowired
    private ElectiveAdapter electiveAdapter;

    public List<Register> getAll() {
        return registerRepository.findAll();
    }

    public List<Register> getRegisterByUserId(String id) {
        User user = userAdapter.getUserById(id);
        int userId = user.getId();
        return registerRepository.findByStudentId(userId);
    }

    public List<Register> getRegisterByElectiveId(int id) {
        Elective elective = electiveAdapter.getElectiveById(id);
        int electiveId = elective.getId();
        return registerRepository.findByElectiveId(electiveId);
    }

    public Register createRegister(String userId, int electiveId, Register register) {
        User user = userAdapter.getUserById(userId);
        Elective elective = electiveAdapter.getElectiveById(electiveId);
        if(user.getYear() >= 3) {
            register.setStudentId(user);
            register.setElectiveId(elective);
        }
        return registerRepository.save(register);
    }

}
