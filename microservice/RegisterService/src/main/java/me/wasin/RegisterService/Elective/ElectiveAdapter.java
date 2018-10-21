package me.wasin.RegisterService.Elective;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ElectiveAdapter {

    public Elective getElectiveById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:3002/elective/" + id;
        Elective elective = restTemplate.getForObject(url, Elective.class);
        return elective;
    }

}
