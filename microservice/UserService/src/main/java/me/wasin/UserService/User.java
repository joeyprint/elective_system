package me.wasin.UserService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String department;

    @NotBlank
    private String faculty;

    private int year;

    public User() {
        super();
    }

    public User(@NotBlank String name, @NotBlank String surname, @NotBlank String department, @NotBlank String faculty, int year) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.faculty = faculty;
        this.year = year;
    }

    public User(String id, @NotBlank String name, @NotBlank String surname, @NotBlank String department, @NotBlank String faculty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.faculty = faculty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }
}