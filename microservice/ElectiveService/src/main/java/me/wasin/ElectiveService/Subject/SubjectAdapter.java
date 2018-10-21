package me.wasin.ElectiveService.Subject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubjectAdapter {

    public Subject getSubjectById(int subjectId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:3001/subject/" + subjectId;
        Subject subject = restTemplate.getForObject(url, Subject.class);
        return subject;
    }
}
