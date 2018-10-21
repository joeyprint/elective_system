package me.wasin.UserService;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class User {

    @Id
    String id = null;

    @NotBlank
    String name = null;

    @NotBlank
    String surname = null;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    Date createdAt = null;

    public String getId() {
        return id;
    }

}