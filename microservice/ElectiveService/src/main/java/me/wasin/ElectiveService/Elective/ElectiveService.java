package me.wasin.ElectiveService.Elective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityListeners;
import java.util.List;

@Service
@EntityListeners(AuditingEntityListener.class)
public class ElectiveService {

    @Autowired
    private ElectiveRepository electiveRepository;

    public List<Elective> getAllElective() {
        return electiveRepository.findAll();
    }

    public Elective getElectiveById(int id) {
        return electiveRepository.findById(id);
    }

    public Elective createElective(Elective elective) {
        return electiveRepository.save(elective);
    }

    public Elective updateTotalRegister(int id, Elective electiveRequest) {
        Elective elective = electiveRepository.findById(id);
        elective.setTotalRegister(electiveRequest.getTotalRegister());
        return electiveRepository.save(elective);
    }

    public Elective deleteElective(int id) {
        Elective elective = electiveRepository.findById(id);
        electiveRepository.delete(elective);
        return elective;
    }

}
