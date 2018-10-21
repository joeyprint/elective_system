package me.wasin.ElectiveService.Elective;

import me.wasin.ElectiveService.Subject.Subject;
import me.wasin.ElectiveService.Subject.SubjectAdapter;
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

    @Autowired
    private SubjectAdapter subjectAdapter;

    public List<Elective> getAllElective() {
        return electiveRepository.findAll();
    }

    public Elective getElectiveById(int id) {
        return electiveRepository.findById(id);
    }

    public Elective createElective(int id, Elective elective) {
        Subject subject = subjectAdapter.getSubjectById(id);
        elective.setSubject(subject);
        elective.setTotalRegister(0);
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
