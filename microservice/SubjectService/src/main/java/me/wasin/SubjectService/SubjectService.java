package me.wasin.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(int id) {
        return subjectRepository.findById(id);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(int id, Subject subjectRequest) {
        Subject subject = subjectRepository.findById(id);
        subject.setSubjectId(subjectRequest.getSubjectId());
        subject.setSubjectName(subjectRequest.getSubjectName());
        subject.setLecturerId(subjectRequest.getLecturerId());
        return subjectRepository.save(subject);
    }

    public Subject deleteSubject(int id) {
        Subject subject = subjectRepository.findById(id);
        subjectRepository.delete(subject);
        return subject;
    }

}
