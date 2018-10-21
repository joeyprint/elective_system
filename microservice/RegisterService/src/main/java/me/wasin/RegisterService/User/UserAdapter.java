package me.wasin.RegisterService.User;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserAdapter {

    public User getUserById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:3000/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

}
